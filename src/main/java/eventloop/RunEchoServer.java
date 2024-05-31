package eventloop;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;
import java.util.stream.IntStream;

public class RunEchoServer implements Runnable {


    public void startServer() throws Exception {

        try (final ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {
            final Selector selector = Selector.open();
            serverSocketChannel.bind(new InetSocketAddress(InetAddress.getLocalHost(), 8080));
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);


            while (true) {
                if (selector.select() < 0)
                    continue;
                selector.selectedKeys().stream().forEach(key -> {
                    if (key.isAcceptable()) {
                        final ServerSocketChannel server = (ServerSocketChannel) key.channel();
                        try {
                            final SocketChannel client = server.accept();
                            if (client != null) {
                                client.configureBlocking(false);
                                client.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE, ByteBuffer.allocate(1024));
                                System.out.println("client connected: " + client);
                            }
                        } catch (IOException e) {
                            //todo
                        }
                    }
                    if (key.isReadable()) {

                    }
                    if (key.isWritable()) {

                    }
                });
            }
        } catch (IOException exception) {
            throw new Exception("Server Exception");
        }
    }

    @Override
    public void run() {
        try {
            startServer();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
