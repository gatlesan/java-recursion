package dp;

public class TrianglePaths {

    public static void main(String[] args) {
        int[][] a = {{1}, {1, 2}, {1, 2, 3}};
        System.out.println(countWays(0, 0, 3, 3));
        int[][] memo = new int[3][3];
        System.out.println(countWaysTab(3, 3, memo));

    }

    private static int countWays(int m, int n, int totalRows, int totalCols) {

        if (m == totalRows-1) {
            return 1;
        }
        int down = countWays(m + 1, n, totalRows, totalCols);
        int dia = countWays(m + 1, n + 1, totalRows, totalCols);
        return down + dia;
    }

    private static int countWaysTab(int m, int n, int[][] memo) {

        for (int i = 0; i < m; i++) {
            memo[m - 1][i] = 1;
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                memo[i][j] = memo[i + 1][j] + memo[i + 1][j + 1];
            }
        }
        return memo[0][0];
    }
}
