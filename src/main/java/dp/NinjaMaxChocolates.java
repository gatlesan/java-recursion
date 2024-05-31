package dp;

public class NinjaMaxChocolates {

    public static void main(String[] args) {

        // int[][] a = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        // int[][] a = {{0, 0, 0}, {0, 0, 0}, {1, 0, 1}};
        // todo - result path (1,3,2) + (2,4,4)
        int[][] a = {{1, 2, 2}, {3, 4, 2}, {1, 2, 4}};
        int n = 3;
        int m = 3;
        System.out.println(maxSumBoth(0, 0, n - 1, n, m, a));

    }

    private static int maxSumBoth(int i, int j1, int j2, int n, int m, int[][] a) {

        //todo - remember always right negative condition first
        if (j1 < 0 || j2 < 0 || j1 > m - 1 || j2 > m - 1) {
            return 0;
        }

        // Base condition
        if (i == n - 1) {
            if (j1 == j2)
                return a[i][j1];
            else
                return a[i][j1] + a[i][j2];
        }

        int maxi = 0;
        for (int k1 = -1; k1 < 2; k1++) {
            for (int k2 = -1; k2 < 2; k2++) {
                if (j1 == j2)
                    maxi = Math.max((a[i][j1] + maxSumBoth(i + 1, j1 + k1, j2 + k2, n, m, a)), maxi);
                else
                    maxi = Math.max((a[i][j1] + a[i][j2] + maxSumBoth(i + 1, j1 + k1, j2 + k2, n, m, a)), maxi);
            }
        }
        return maxi;
    }
}
