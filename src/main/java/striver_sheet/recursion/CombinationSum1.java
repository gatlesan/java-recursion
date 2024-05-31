package striver_sheet.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum1 {

    public static void main(String[] args) {


        List<Integer> list = Arrays.asList(2, 3, 6, 7);
        int target = 7;

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> counter = new ArrayList<>();
        //System.out.println(combinations(list, 0, target, new ArrayList<>(), res, counter));
//        System.out.println(counter);
//        System.out.println(combinations1(list, 0, target, new ArrayList<>(), res, counter));
//        System.out.println(counter);
        Object[][] m = new Object[list.size()][target+1];
        System.out.println(combinationsMemo(list, 0, target, new ArrayList<>(), res, m, counter));
        System.out.println(counter);
    }


    //*** Both combinations and combinations1 is returning the same result...
    // [[2, 2, 3], [2, 2, 3], [2, 2, 3], [7]]
    private static List<List<Integer>> combinations(List<Integer> arr, int i, int target, List<Integer> memo, List<List<Integer>> res, List<Integer> counter) {

        counter.add(counter.size() + 1);
        if (target < 0 || i > arr.size() - 1) {
            return null;
        }

        if (target == 0) {
            res.add(new ArrayList<>(memo));
        }

        int val = arr.get(i);
        memo.add(val);
        //*** do not do (target - val) instead pass it, if you pass you don't have to remove it back in recursion
        combinations(arr, i, target - val, memo, res, counter);
        memo.remove(memo.indexOf(val));
        //target = target + val;
        combinations(arr, i + 1, target, memo, res, counter);
        return res;
    }


    // O(2^t)*k where t is target where k is the avg size of elements to add to result
    // Space Complexity: O(k*x), k is the average length and x is the no. of combinations
    private static List<List<Integer>> combinations1(List<Integer> arr, int i, int target, List<Integer> memo, List<List<Integer>> res, List<Integer> counter) {

        counter.add(counter.size() + 1);
        if (i > arr.size() - 1) {
            return null;
        }

        if (target == 0) {
            res.add(new ArrayList<>(memo));
        }

        if (arr.get(i) <= target) {
            memo.add(arr.get(i));
            combinations1(arr, i, target - arr.get(i), memo, res, counter);
            memo.remove(memo.indexOf(arr.get(i)));
        }
        combinations1(arr, i+1, target, memo, res, counter);
        return res;
    }

    //memoization... O(n^2)
    private static List<List<Integer>> combinationsMemo(List<Integer> arr, int i, int target, List<Integer> memo, List<List<Integer>> res, Object[][] m,List<Integer> counter) {

        counter.add(counter.size() + 1);
        if (i > arr.size() - 1) {
            return null;
        }

        if (target == 0) {
            m[i][target] =  new ArrayList<>(memo);
            res.add(new ArrayList<>(memo));
        }

        if(m[i][target] != null) {
            return null;
        }

        if (arr.get(i) <= target) {
            memo.add(arr.get(i));
            combinationsMemo(arr, i, target - arr.get(i), memo, res, m, counter);
            memo.remove(memo.indexOf(arr.get(i)));
        }
        combinationsMemo(arr, i+1, target, memo, res, m, counter);
        return res;
    }
}
