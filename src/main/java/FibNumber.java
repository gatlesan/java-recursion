public class FibNumber {

    public static void main(String[] args) {
        System.out.println(getNFibNumber(5));
    }

    private static int getNFibNumber(int n) {

        // or if(n <= 1) return n
        if(n == 1)
            return 0;
        if(n == 2)
            return 1;
        return getNFibNumber(n-1)+getNFibNumber(n-2);
    }
}
