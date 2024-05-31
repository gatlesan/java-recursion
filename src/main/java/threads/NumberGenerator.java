package threads;

import java.util.concurrent.Callable;

public class NumberGenerator implements Callable<Double> {
    @Override
    public Double call() throws Exception {
        return Math.random();
    }
}
