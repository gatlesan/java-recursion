package striver_sheet.recursion;

import java.util.*;

public class CombinationSum2 {

    // find all unique combinations of given sum - one element can only be taken once in a combination...
    public static void main(String[] args) {

        List<Integer> temp = Arrays.asList(10,1,2,7,6,1,5);
        //Q's says one element can only be used once from example 1,1 should come once
        //using set to filter the duplicates is not the solution...
        //*** Pattern:---------
        // for loop in a recursion call will make sure that you will not pick the value more than once
        // that is you skip the next value if i-1 or prev val is same...
        // pre-requisite sort the given array because Q says that the order is needed


        List<Integer> list = new ArrayList<>(new HashSet<>(temp));
        //System.out.println(list);
        List<List<Integer>> res = new ArrayList<>();
        int target = 8;
        // System.out.println(uniqueCombinations(list,0,target,new ArrayList<>(),res));


        //*** practice recursion tree with [1,1,1,2,2] and t = 4
        List<Integer> arr = Arrays.asList(10,1,2,7,6,1,5);
        Collections.sort(arr);
        System.out.println(arr);
        int t = 8;
        uniqueCombinations(arr, 0, t, new ArrayList<>(), res);
        System.out.println(res);


    }


    //pattern: https://takeuforward.org/data-structure/combination-sum-ii-find-all-unique-combinations/
    //*** 1. for loop from j where j = i to size-1
    //*** 2. you do not pick the j-1 val at j if a[j] == a[j-1] && you do not check it for first case that is where i!=j
    //*** 3. At any point if t > a[j] we can't take j any further as arr is sorted ... break the loop
    //*** 4. take -> call and remove (remember inside for loop in this pattern) we will not call function twice as for loop is doing it ...

    private static void uniqueCombinations(List<Integer> arr, int i, int target, List<Integer> ds, List<List<Integer>> res) {

        if(target == 0) {
            res.add(new ArrayList<>(ds));
            return;
        }

        for (int j = i; j < arr.size() - 1; j++) {
            if(j > i && arr.get(j-1) == arr.get(j)) continue;
            if(arr.get(j) > target) break;
            ds.add(arr.get(j));
            uniqueCombinations(arr,j+1,target-arr.get(j),ds,res);
            ds.remove(ds.size() - 1);
        }
    }
}
