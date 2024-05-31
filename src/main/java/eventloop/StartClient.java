package eventloop;

import java.io.IOException;

public class StartClient {
    public static void main(String[] args) throws IOException {
        EchoClient echoClient = new EchoClient();
        echoClient.startClient();
    }
}
