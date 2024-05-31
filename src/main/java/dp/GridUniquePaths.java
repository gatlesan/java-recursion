package dp;

import jdk.jshell.spi.SPIResolutionException;

public class GridUniquePaths {

    public static void main(String[] args) {

        int[][] grid = {{1, 0, 2}, {6, 4, 3}, {2, 1, 5}};
        int m = 3;
        int n = 3;
        System.out.println(countUniquePaths(m - 1, n - 1));
        int[][] memo = new int[m][n];
        System.out.println(countUniquePathsMemo(m - 1, n - 1, memo));
        int[][] memo1 = new int[m][n];
        System.out.println(countUniquePathsTab(m - 1, n - 1, memo1));
        System.out.println(countUniquePathsSpaceOpt(m, n));
    }

    private static int countUniquePaths(int m, int n) {

        if (m == 0 && n == 0)
            return 1;
        if (m == -1 || n == -1)
            return 0;
        int up = countUniquePaths(m - 1, n);
        int down = countUniquePaths(m, n - 1);
        return up + down;
    }

    private static int countUniquePathsMemo(int m, int n, int[][] memo) {

        if (m == 0 && n == 0)
            return 1;
        if (m == -1 || n == -1)
            return 0;
        if (memo[m][n] > 0)
            return memo[m][n];

        int up = countUniquePaths(m - 1, n);
        int down = countUniquePaths(m, n - 1);
        memo[m][n] = up + down;
        return memo[m][n];
    }

    private static int countUniquePathsTab(int m, int n, int[][] memo) {

        memo[0][0] = 1;

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (!(i == 0 && j == 0)) {
                    int up = i > 0 ? memo[i - 1][j] : 0;
                    int down = j > 0 ? memo[i][j - 1] : 0;
                    memo[i][j] = up + down;
                }
            }
        }
        return memo[m][n];
    }

    //space optimization from O(mxn) to O(n)
    private static int countUniquePathsSpaceOpt(int m, int n) {

        int[] prev = new int[m];
        for (int i = 0; i < m; i++) {
            int[] curr = new int[n];
            for (int j = 0; j < n; j++) {
                if(i == 0 && j == 0) {
                    curr[j] = 1;
                }
                if (!(i == 0 && j == 0)) {
                 curr[j] = prev[j] + (j > 0 ? curr[j-1] : 0);
                }
            }
            prev = curr;
        }
        return prev[m-1];
    }
}
