package dp;

public class LongestIncreasingSubSeq {

    public static void main(String[] args) {

        int[] a = {10, 9, 0, 2, 5, 3, 7, 101, 18};
        int n = a.length;
        int[][] twoDimArray = new int[n][n];


        System.out.println(longestIncSubSeq(0, -1, a, twoDimArray));
    }

    private static int longestIncSubSeq(int i, int pi, int[] a, int[][] twoDimArray) {

        if (i == a.length)
            return 0;

        if (twoDimArray[i][pi + 1] != 0) {
            System.out.println("[" + twoDimArray[i][pi + 1] + "]");
            return twoDimArray[i][pi + 1];
        }

        int len1 = 0;
        int len2 = longestIncSubSeq(i + 1, pi, a, twoDimArray);
        if (pi == -1 || a[i] > a[pi])
            len1 = 1 + longestIncSubSeq(i + 1, i, a, twoDimArray);
        int max = Math.max(len1, len2);
        twoDimArray[i][pi + 1] = max;
        return max;

    }
}
