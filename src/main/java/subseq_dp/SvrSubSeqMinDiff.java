package subseq_dp;

public class SvrSubSeqMinDiff {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int k = 5;
        int[][] memo = new int[arr.length][k+1];
        System.out.println(findDiff(arr.length-1, k, arr, memo));
        for (int i=0; i<arr.length; i++) {
            for(int j=0; j<=k; j++) {
                System.out.print(memo[i][j]);
            }
            System.out.println();
        }

        System.out.println(findDiffTab(k,arr));
    }

    private static boolean findDiff(int i, int k, int[] arr, int[][] memo) {

        if (k == 0 || arr[i] == k)
            return true;
        if (i == 0)
            return false;

        if(memo[i][k] != 0)
            return memo[i][k] == 1;

        boolean take = false;
        if (k > arr[i])
            take = findDiff(i - 1, k - arr[i], arr, memo);
        boolean nonTake = findDiff(i-1, k, arr, memo);
        memo[i][k] = (take || nonTake) ? 1 : -1;
        return memo[i][k] == 1;
    }

    private static boolean findDiffTab(int k, int[] arr) {

        boolean[][] memo = new boolean[arr.length][k+1];
        for(int i=0; i<arr.length; i++) {
            memo[i][0] = true;
        }

        memo[0][arr[0]] = true;

        for(int i=1;i<arr.length;i++) {
            for(int j=1; j<=k; j++) {
                boolean take = false;
                if (j > arr[i])
                    take = memo[i - 1][j - arr[i]];
                boolean nonTake = memo[i-1][j];
                memo[i][j] = take || nonTake;
            }
        }

        for (int i=0; i<arr.length; i++) {
            for(int j=0; j<=k; j++) {
                System.out.print(memo[i][j]);
            }
            System.out.println();
        }

        return memo[arr.length-1][k];
    }
}
