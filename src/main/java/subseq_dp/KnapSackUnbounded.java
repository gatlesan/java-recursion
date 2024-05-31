package subseq_dp;

public class KnapSackUnbounded {
    public static void main(String[] args) {

        int[] weightArray = {2,4,6};
        int[] valueArray = {5,11,13};
        int w = 10;
        int ind = weightArray.length-1;
        System.out.println(findMaxVal(ind, w, weightArray, valueArray));

    }

    private static int findMaxVal(int ind, int w, int[] weightArray, int[] valueArray) {

        if (w == 0) {
            return 0;
        }
        if (ind == 0) {
            if (w >= weightArray[ind]) {
                return valueArray[ind];
            } else {
                return Integer.MIN_VALUE;
            }
        }
        int nonTake = findMaxVal(ind - 1, w, weightArray, valueArray);
        int take = Integer.MIN_VALUE;
        if (w >= weightArray[ind]) {
            // todo - remember no ind-1 for unbounded or infinite take of single element till a condition is met
            return valueArray[ind] + findMaxVal(ind, w - weightArray[ind], weightArray, valueArray);
        }
        return Math.max(take, nonTake);
    }
}
