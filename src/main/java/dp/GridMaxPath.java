package dp;

//variable starting and variable ending
public class GridMaxPath {
    public static void main(String[] args) {

        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int n = 3;
        int m = 3;

        int max = 0;
        for (int i = 0; i < m; i++) {
            int maxTemp = maxPath(n - 1, i, a, n, m);
            max = maxTemp > max ? maxTemp : max;
        }

        System.out.println(max);

        System.out.println(maxPathTab(3, 3, a));

        System.out.println(maxPathTabSpaceOptimization(3, 3, a));
    }

    private static int maxPath(int i, int j, int[][] a, int n, int m) {

        // todo - remember j can go out of bound when i == 0, first check this...
        if (j < 0 || j > m - 1) return 0;
        if (i == 0) return a[i][j];
        int up = a[i][j] + maxPath(i - 1, j, a, n, m);
        int leftUp = a[i][i] + maxPath(i - 1, j - 1, a, n, m);
        int rightUp = a[i][j] + maxPath(i - 1, j + 1, a, n, m);
        return Math.max(up, Math.max(rightUp, leftUp));

    }

    private static int maxPathTab(int n, int m, int[][] a) {

        int[][] memo = new int[n][m];
        for (int k = 0; k < m; k++) {
            memo[0][k] = a[0][k];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int up = a[i][j] + memo[i - 1][j];
                // todo - remember brackets for ternary condition
                int leftUp = a[i][i] + (j > 0 ? memo[i - 1][j - 1] : 0);
                int rightUp = a[i][j] + (j < m - 1 ? memo[i - 1][j + 1] : 0);
                memo[i][j] = Math.max(up, Math.max(rightUp, leftUp));
            }
        }
        return memo[n - 1][m - 1];
    }

    // space optimized from O(NxM) to O(N)
    private static int maxPathTabSpaceOptimization(int n, int m, int[][] a) {
        int[] prev = new int[m];
        for (int k = 0; k < m; k++) {
            prev[k] = a[0][k];
        }

        int[] curr;
        for (int i = 1; i < n; i++) {
            curr = new int[n];
            for (int j = 0; j < m; j++) {
                int up = a[i][j] + prev[j];
                int leftUp = a[i][i] + (j > 0 ? prev[j - 1] : 0);
                int rightUp = a[i][j] + (j < m - 1 ? prev[j + 1] : 0);
                curr[j] = Math.max(up, Math.max(rightUp, leftUp));
            }
            prev = curr;
        }
        return prev[n - 1];
    }
}
