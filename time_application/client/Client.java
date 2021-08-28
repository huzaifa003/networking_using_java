package client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {
    public static void main(String[] args) throws IOException {
        InetSocketAddress inetSocketAddress = new InetSocketAddress("localhost",3000); //WATCH AS PORT IS SAME AS CLIENT SIDE

        SocketChannel socketChannel = SocketChannel.open(inetSocketAddress); //opening socket on client side with address to Server Side

        //-----------READING FROM CLIENT SIDE----------------\\
        ByteBuffer buffer = ByteBuffer.allocate(64);
        int byteRead = socketChannel.read(buffer);

        while (byteRead > 0)
        {
            buffer.flip();
            while (buffer.hasRemaining())
            {
                System.out.print((char) buffer.get());
            }
            System.out.println();
            byteRead = socketChannel.read(buffer); //reading from buffer from server
        }

        //=====================================================\\

        //-----------WRITING TO SERVER SIDE---------------\\
        buffer = ByteBuffer.allocate(64);

        String message = "HELLO FROM CLIENT SIDE";
        System.out.println("SENDING TO SERVER NOW" + " '" +  message + "'");
        buffer.put(message.getBytes());
        buffer.flip();
        while (buffer.hasRemaining())
        {
            socketChannel.write(buffer);
        }
        System.out.println();
        //===============================================\\

    }
}
