package threads;

import java.util.concurrent.*;

public class Task {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        System.out.println("Running this from "+Thread.currentThread().getName());
        PrintHelloWorld printHelloWorld = new PrintHelloWorld();
        Thread task1 = new Thread(printHelloWorld);

        task1.run(); // no new thread is created
        task1.start(); // start creates a new thread



    /*    for(int i =0; i< 100; i++) {
            Thread t = new Thread(new PrintNumber(i+1));
            t.start();
        }*/

        ExecutorService executorService = Executors.newFixedThreadPool(2);
   /*     for(int i =0; i< 100; i++) {
            executorService.execute(new PrintNumber(i+1));
        }*/

        NumberGenerator gen1 = new NumberGenerator();
        NumberGenerator gen2 = new NumberGenerator();

        Future<Double> numFuture1 = executorService.submit(gen1);
        Future<Double> numFuture2 = executorService.submit(gen1);


        // blocking call ... get blocks the current thread
        Double num1 = numFuture1.get();
        // blocking call ... get blocks the current thread
        Double num2 = numFuture1.get();

        // System.out.println(num1+num2);

        // supplyAsync runs under the hood spawn's a new thread and calls the run and then returns completable future
        CompletableFuture<Double> completableFuture = CompletableFuture.supplyAsync(() -> {
            Double num = Double.valueOf(0);
            try {
                num = numFuture1.get();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
            return num;
        });



        // completableFuture.thenAccept(v -> System.out.println(v));

        executorService.shutdown();




        //java promise...

        PromiseDemo promiseDemo = new PromiseDemo();
        promiseDemo.getAsyncValue().thenAcceptAsync(res -> {
            System.out.println(res);
        });

        System.out.println("done");
    }
}
