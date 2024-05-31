package functional;

import java.util.function.BiFunction;

public class MainDemo {

    public static void main(String[] args) {

        System.out.println("Addition "+ getResult((a,b) -> a+b, 12, 13));
        System.out.println("Subtraction "+ getResult((a,b) -> a-b, 13, 10));
    }

    private static int getResult(DoMath doMath, int a, int b) {
        return doMath.calc(a, b);
    }
}


