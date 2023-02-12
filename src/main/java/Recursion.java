public class Recursion {

    public static void main(String[] args) {
        printTillN(5);
    }
    // do not use ++ print using back tracking
    private static void printTillN(int n) {
        //terminating/base condition
        if(n < 1)
            return;
        printTillN(n-1);
        System.out.println(n);
    }
}

