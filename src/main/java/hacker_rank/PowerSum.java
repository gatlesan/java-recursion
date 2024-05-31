package hacker_rank;

public class PowerSum {

    public static void main(String[] args) {

        System.out.println(powerSum(100, 1, 3));

    }

    private static int powerSum(int total, int i, int k) {

        if (total == 0) {
            return 1;
        }
        if (total < 0) {
            return 0;
        }
        // right tree needs a terminating condition, as total is not being reduced by i^k
        if (Math.pow(i, k) > total) {
            return 0;
        }
        int l = powerSum((int) (total - Math.pow(i, k)), i + 1, k);
        int r = powerSum(total, i + 1, k);
        return l + r;

    }
}
