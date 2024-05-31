package dp;

// stairs climbing allways possible
public class AllPossibleWays {

    public static void main(String[] args) {

        System.out.println(allWays(10));
        System.out.println(Math.abs(-20));
    }

    private static int allWays(int n) {

        if(n == 1) return 1;
        if(n < 1) return 0;

        int left = allWays(n-1);
        int right = allWays(n-2);

        return left + right;

    }
}
