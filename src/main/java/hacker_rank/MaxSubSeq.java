package hacker_rank;

import java.util.*;

public class MaxSubSeq {

    public static void main(String[] args) {

        List<Integer> arr = Arrays.asList(-2,-3,-1);
        List<Integer> res = findMax(0, new ArrayList<>(), arr.size(), arr);
        // System.out.println(res);

        // array = [1,2,3,4]
        // Subarray : [1,2],[1,2,3] - is continous and maintains relative order of elements
        // Subsequence: [1,2,4] - is not continous but maintains relative order of elements
        // Subset: [1,3,2] - is not continous and does not maintain relative order of elements


        Map<List<Integer>, Integer> memo = new HashMap<>();
        System.out.println(findSubSeqMaxSum(0, 0, arr.size(), arr, memo));
        List<Integer> arr1 = Arrays.asList(1,-2,3,-3);
        System.out.println(findSubSeqMaxSum(arr.size()-1, 0, arr));
       // printAll(arr.size()-1, new ArrayList<>(), arr.size() , arr);
    }

    // contiguous subsequence
    private static List<Integer> findMax(int i, List<Integer> res, int n, List<Integer> arr) {

        if(i >= n) {
            // System.out.println(res);
            // ********************************
            // remember to return a new list
            return new ArrayList<>(res);
        }

        int t = arr.get(i);
        res.add(t);
        List<Integer> l = findMax(i+1, res, n, arr);
        res.remove(res.indexOf(t));
        List<Integer> r = findMax(i+1, res, n, arr);
        // System.out.println(l + " " + r);
        List<Integer> m = findSum(l) > findSum(r) ? l : r;
        // System.out.println(m);
        return m;
    }

    private static int findSum(List<Integer> list) {
        int sum = 0;
        for(int i=0;i<list.size();i++) {
            sum = sum + list.get(i);
        }
        // System.out.println(sum);
        return sum;
    }


    private static int findSubSeqMaxSum(int i, int sum, int n, List<Integer> arr,Map<List<Integer>, Integer> memo) {

        if(i > n-1){
            // ****** return MIN_VALUE if sum is 0 for tests which has negative numbers
            return sum == 0 ? Integer.MIN_VALUE : sum;
        }
        if(memo.get(Arrays.asList(i,sum))!= null) {
            return memo.get(Arrays.asList(i,sum));
        }
        int l = findSubSeqMaxSum(i+1, sum+arr.get(i), n, arr, memo);
        int r = findSubSeqMaxSum(i+1, sum, n, arr, memo);
        memo.put(Arrays.asList(i,sum), Math.max(l,r));
        return memo.get(Arrays.asList(i,sum));
    }

    //-2,-3,-1
    private static int findSubSeqMaxSum(int i, int sum, List<Integer> arr) {

        if(i < 0) {
            //System.out.println(sum);
            //In non take 0 is compared with negative numbers and always returns 0, therefore use MIN_VALUE
            return sum == 0 ? Integer.MIN_VALUE : sum;
        }
        //take add to sum
        int l = findSubSeqMaxSum(i-1, sum + arr.get(i), arr);
        // non take do not add to sum
        int r = findSubSeqMaxSum(i-1, sum, arr);
        System.out.println(l + " ** " + r);
        return Math.max(l,r);
    }

    //what is the time complexity of findSubSeqMaxSum?
    //O(n^2)

    private static void printAll(int i, List<Integer> res, int n, List<Integer> arr) {

        if(i < 0) {
            System.out.println(res);
            return;
        }

        res.add(arr.get(i));
        printAll(i-1, res, n, arr);
        res.remove(res.indexOf(arr.get(i)));
        printAll(i-1, res, n, arr);
    }
}
