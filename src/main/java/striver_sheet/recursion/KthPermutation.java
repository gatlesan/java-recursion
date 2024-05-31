package striver_sheet.recursion;

import arrays.InsertionSortPart1;
import striver_sheet.linked_list.LinkedListCycle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class KthPermutation {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3,4};

        List<List<Integer>> res = new ArrayList<>();
        p(arr,0,res);
        System.out.println(res);


    }


    // finding all the permutations order them and then return the k-1
    // k-1 as res will be o based...
    // This is BF, there is away to achieve this without using recursion
    private static void p(int[] a, int i, List<List<Integer>> res) {

        if (i == a.length) {
            return;
        }

        List<Integer> list = new ArrayList<>();
        list.add(a[i]);
        for (int j = 0; j < a.length; j++) {
            if(i != j) {
                list.add(a[j]);
            }
        }

        List<Integer> list1 = new ArrayList<>();
        list1.add(a[i]);
        for (int k = a.length - 1; k >= 0; k--) {
            if(i != k) {
                list1.add(a[k]);
            }
        }

        res.add(list);
        res.add(list1);
        p(a, i + 1, res);
    }

    // 1. Without using extra space for storing intermediate results/ using swapping
    // 2. pattern swap call swap back to the original position, at i == ar.size() add ds to ans
    // TC: O(n!)*n n is for the loop to move the fixed positions from 0 to n-1
    private static void permutationOptimal() {

    }
}
