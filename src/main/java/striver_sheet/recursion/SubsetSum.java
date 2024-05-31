package striver_sheet.recursion;

import java.util.*;

public class SubsetSum {

    public static void main(String[] args) {


        //BF: power set O(2^n) * n
        List<Integer> list = Arrays.asList(5, 2, 1);
        List<Integer> res = new ArrayList<>();
        findSubsetSum(list, 0, 0, res);
        Collections.sort(res);
        System.out.println(res);
    }

    //O(2^n) and for sorting it will take (2^n log(2^n)).
    private static List<Integer> findSubsetSum(List<Integer> list, int i, int s, List<Integer> res) {

        if (i >= list.size()) {
            res.add(s);
            return null;
        }
        findSubsetSum(list, i+1, s+=list.get(i), res);
        findSubsetSum(list, i+1, s-=list.get(i), res);
        return res;

    }
}
