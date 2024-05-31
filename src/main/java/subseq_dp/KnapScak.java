package subseq_dp;

public class KnapScak {

    public static void main(String[] args) {
        int W = 6;
        int[] warry = {3, 2, 4};
        int[] varry = {30, 40, 60};
        int[][] memo = new int[warry.length][W+1];
        System.out.println(findMax(warry.length - 1, W, warry, varry, memo));



    }

    private static int findMax(int ind, int w, int[] warray, int[] varry, int[][] memo) {

        if (ind < 0) {
            return 0;
        }
        if (memo[ind][w] > 0 || memo[ind][w] == -1) {
            return memo[ind][w] == -1 ? 0 : memo[ind][w];
        }
        int take = 0;
        if (w >= warray[ind]) {
            take = varry[ind] + findMax(ind - 1, w - warray[ind], warray, varry, memo);
        }
        int nonTake = findMax(ind - 1, w, warray, varry, memo);
        int maxVal = Math.max(take, nonTake);
        memo[ind][w] = maxVal == 0 ? -1 : maxVal;
        return memo[ind][w];
    }


}