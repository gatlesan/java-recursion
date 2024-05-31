package subseq_dp;

public class MinCoins {
    public static void main(String[] args) {

        int[] arr = {1,2,3};
        int target = 8;
        System.out.println(findMin(arr.length-1, target, arr));
        int[][] memo = new int[arr.length][target+1];
        System.out.println(findMinMemo(arr.length-1, target, arr, memo));
    }

    private static int findMin(int ind, int target, int[] arr) {


        if(ind == 0) {
            // remember this...
            if(target % arr[ind] == 0) {
                return target/arr[ind];
            } else {
                return Integer.MAX_VALUE;
            }
        }

        int nonTake = findMin(ind-1, target, arr);
        int take = Integer.MAX_VALUE;
        if(target >= arr[ind]) {
            take = 1 + findMin(ind, target-arr[ind], arr);
        }
        return Math.min(take, nonTake);

    }

    private static int findMinMemo(int ind, int target, int[] arr, int[][] memo) {


        if(memo[ind][target] > 0) {
            return memo[ind][target];
        }

        if(ind == 0) {
            // remember this...
            if(target % arr[ind] == 0) {
                return target/arr[ind];
            } else {
                return Integer.MAX_VALUE;
            }
        }

        int nonTake = findMin(ind-1, target, arr);
        int take = Integer.MAX_VALUE;
        if(target >= arr[ind]) {
            take = 1 + findMin(ind, target-arr[ind], arr);
        }
        memo[ind][target] =  Math.min(take, nonTake);
        return memo[ind][target];

    }
}
