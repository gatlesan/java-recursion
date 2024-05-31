package threads;

public class PrintHelloWorld implements Runnable{
    @Override
    public void run() {
        System.out.println("Hello world printed using "+Thread.currentThread().getName());
    }
}
