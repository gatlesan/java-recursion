package striver_sheet.recursion;

import java.util.*;

public class UniqueSubsets {

    public static void main(String[] args) {

        Set<List<Integer>> s = new HashSet<>();
        s.add(Arrays.asList(2, 2));
        s.add(Arrays.asList(2, 2));

        System.out.println(s);

        Set<List<Integer>> res = new HashSet<>();
        List<Integer> memo = new ArrayList<>();
        System.out.println(find(Arrays.asList(1, 2, 2), 0, memo, res));
        // print(1, 4);

        List<List<Integer>> res1 = new ArrayList<>();
        System.out.println(findOptimal(Arrays.asList(1, 2, 2), 0, memo, res1));
    }



    //Return only unique subsets and they can be in any order.
    //use HashSet for subsets
    private static Set<List<Integer>> find(List<Integer> arr, int i, List<Integer> memo, Set<List<Integer>> res) {


        if (i > arr.size() - 1) {
            //*** very important create a new arraylist of memo and add to the result
            res.add(new ArrayList<>(memo));
            return null;
        }
        memo.add(arr.get(i));
        find(arr, i + 1, memo, res);
        memo.remove(memo.indexOf(arr.get(i)));
        find(arr, i + 1, memo, res);
        return res;

    }


    //*** Optimize the recursion to not use set to avoid getting duplicate subset
    private static List<List<Integer>> findOptimal(List<Integer> arr, int i, List<Integer> memo, List<List<Integer>> res) {
        res.add(new ArrayList<>(memo));
        for(int j=i;j<arr.size();j++) {
            if(j!=i && arr.get(j) == arr.get(j-1)) {
                continue;
            }
            memo.add(arr.get(j));
            findOptimal(arr, i + 1, memo, res);
            memo.remove(memo.indexOf(arr.get(j)));
        }
        return res;
    }



    //*** Optimize the recursion to not use set
    //*** Understand running recursion function in levels 0,1,2,.... using for loop
    //*** Left recursion tree will complete first...
    private static void print(int i, int k) {
        for (int j = i; j < k; j++) {
            System.out.println("j "+j +" for i "+i);
            print(i+1, k);
        }
    }
}


