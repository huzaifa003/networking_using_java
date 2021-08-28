package server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;

/*
    * channel is a medium that transports data using buffer
    * a socket is opened ona channel
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open(); //opening a channel
        //.socket() method gets the socket related to the channel
        serverSocketChannel.socket().bind(new InetSocketAddress(3000)) ; //binding the opened socket to IP address 0.0.0.0 (default cause we did not specify) and port 3000
        while (true)
        {
            System.out.println("waiting for request");
            SocketChannel socketChannel =  serverSocketChannel.accept(); //accept() returns the channel of incoming connection but only if this channel aint in non blocking mode
            if (socketChannel != null)
            {
                //-----------WRITING TO CLIENT SIDE---------------\\
                System.out.println(socketChannel.getLocalAddress() + "    ACCEPTED");
                String DATE = "DATE : From SERVER SIDE    " +  new Date(System.currentTimeMillis());
                System.out.println("SENT:  " + DATE  );
                ByteBuffer buffer = ByteBuffer.allocate(64); //allocate buffer memory
                buffer.put(DATE.getBytes()); //write data to client
                buffer.flip(); //sets position as 0 its like flush()

                while (buffer.hasRemaining())
                {
                    socketChannel.write(buffer); //writing to buffer aka to CLIENT
                }

                //===================================================\\


                //-----------READING FROM CLIENT SIDE----------------\\
                buffer = ByteBuffer.allocate(64);

                int bytes = socketChannel.read(buffer);

                while (bytes > 0)
                {
                    buffer.flip();
                    while (buffer.hasRemaining())
                    {
                        System.out.print((char) buffer.get());
                    }
                    System.out.println();
                    bytes = socketChannel.read(buffer);
                }

                //==================================================\\
            }

        }
    }
}
