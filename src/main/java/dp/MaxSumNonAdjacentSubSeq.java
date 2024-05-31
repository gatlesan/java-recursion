package dp;

public class MaxSumNonAdjacentSubSeq {

    public static void main(String[] args) {

        int[] a = {2, 1, 4, 9};
        System.out.println(maxSum(a.length-1, a));
        System.out.println(maxSumMemo(a.length-1, a ,new int[a.length]));
        System.out.println(maxSumTab(a));
    }

    private static int maxSum(int i, int[] a) {

        if(i < 0)
            return 0;
        if(i == 0)
            return a[i];

        int pick = a[i] + maxSum(i-2, a);
        int nonPick = maxSum(i - 1, a);
        return Math.max(pick, nonPick);

    }

    private static int maxSumMemo(int i, int[] a, int[]  memo) {

        if(i < 0)
            return 0;
        if(i == 0)
            return a[i];

        if(memo[i] > 0)
            return memo[i];

        int pick = a[i] + maxSum(i-2, a);
        int nonPick = maxSum(i - 1, a);
        memo[i] = Math.max(pick, nonPick);
        return memo[i];

    }

    private static int maxSumTab(int[] a) {

        int[] memo = new int[a.length];
        memo[0] = a[0];
        int neg = 0;

        for(int j = 1; j < a.length; j++) {
            int pick = a[j] + (j > 1 ? memo[j-2] : neg);
            int nonPick = 0 + memo[j-1];
            memo[j] = Math.max(pick, nonPick);
        }

        return findMax(memo);
    }

    private static int findMax(int[] a) {
        int max = 0;
        for(int i=0; i<a.length; i++) {
            max = a[i] > max ? a[i] : max;
        }
        return max;
    }

}
