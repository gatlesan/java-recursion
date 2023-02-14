public class Recursion {

    public static void main(String[] args) {
        printTillN(5);
        System.out.println(sumOfN(5));
    }
    // do not use ++ print using back tracking
    private static void printTillN(int n) {
        //terminating/base condition
        if(n < 1)
            return;
        printTillN(n-1);
        System.out.println(n);
    }

    // Sum of first N numbers
    private static int sumOfN(int n) {
        if(n == 0)
            return 0;
        return n + sumOfN(n-1);
    }
}

