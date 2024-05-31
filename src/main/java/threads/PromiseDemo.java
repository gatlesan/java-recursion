package threads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PromiseDemo {

    public CompletableFuture<Double> getAsyncValue() throws ExecutionException, InterruptedException {
        CompletableFuture<Double> promise =  new CompletableFuture<>();
        //Promise.resolve(856.0);
        //promise.complete(856.0);
        System.out.println(promise.isDone());
        Future<Double> doubleFuture = Executors.newFixedThreadPool(10).submit(new NumberGenerator());
        promise.complete(doubleFuture.get());
        return promise;
    }
}
