package threads;

public class PrintNumber implements Runnable{
    int num;
    PrintNumber(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println(this.num + " Printed using "+Thread.currentThread().getName());
    }
}
