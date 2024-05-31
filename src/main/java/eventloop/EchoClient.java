package eventloop;

import java.io.IOException;
import java.net.Socket;

public class EchoClient implements Runnable {
    public void startClient() throws IOException {
        Socket socket = new Socket("192.168.0.106", 8080);
        System.out.println(socket.isConnected());
        socket.getOutputStream();
        // socket.close();
    }

    @Override
    public void run() {
        try {
            startClient();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
