package subseq_dp;

import java.util.HashMap;
import java.util.Map;

//check if given sum can be formed by a subset/subsequence
// 1. top down
public class SubSeqFindSum {
    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4};
        //assumption that k < 1000 (10 pow 3)
        boolean[][] memo = new boolean[a.length][1000];
        //without any assumptions
        Map<Map<Integer, Integer>, Boolean> memoMap = new HashMap();
        System.out.println(findSubSeq(a.length - 1, 19, a, memo));
        boolean[][] memoTab = new boolean[a.length][1000];
        System.out.println(finSubSeqTab(a.length, 11, a, memoTab));
    }

    private static boolean findSubSeq(int i, int k, int[] a, boolean[][] memo) {

        if (k < 0)
            return false;

        if (a[i] == k || k == 0)
            return true;
        if (i == 0)
            return false;
        if(memo[i][k]) {
            return true;
        }

        boolean take = false;
        //take
        if (k >= a[i]) {
            take = findSubSeq(i - 1, k - a[i], a, memo);
        }
        // non take
        boolean nonTake = findSubSeq(i - 1, k, a, memo);
        memo[i][k] = take || nonTake;
        return memo[i][k];
    }

    private static boolean finSubSeqTab(int i, int k, int[] a, boolean[][] memo) {

        for (int l = 0; l < a.length; l++) {
            memo[l][0] = true;
        }

        // a[0] will always be @ index 0
        memo[0][a[0]] = true;

        for (int m = 1; m < a.length; m++) {
            for (int n = 1; n <= k; n++) {
                boolean take = false;
                //take
                if (n >= a[m]) {
                    take = memo[m - 1][n - a[m]];
                }
                boolean nonTake = memo[m - 1][n];
                memo[m][n] = take || nonTake;
            }
        }
        return memo[a.length - 1][k];
    }
}
