package eventloop;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NonBlockingIO {
    public static void main(String[] args) throws Exception {


        Thread serverThread = new Thread(new RunEchoServer());
        serverThread.setPriority(1);
        serverThread.start();

        Thread.sleep(5000);

        Thread clientThread = new Thread(new EchoClient());
        clientThread.setPriority(10);
        clientThread.start();

        Thread.sleep(5000);
        // Thread c = new Thread(new EchoClient());
    }
}


