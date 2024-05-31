package striver_sheet.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NextPermutation {

    // Permutation --> Arrangement n!/(n-r)!
    // Combination --> Selection n!/(n-r)!*r!

    // {1,2,3}
    // Permutation --> 6 {1,2} {1,3} {2,3} --> arrange {2,1} {3,1} {3,2}
    // Combination --> 3 {1,2} {1,3} {2,3}

    // Brute force
    // 1. find all combinations and sort them and find n+1 element

    //Optimal
    //Find the index where element is decreasing
    //swap the index with next possible higher value x > i and < max
    //reverse the rest of the elements
    //example {2,3,5,4,1,0,0}
    public static void main(String[] args) {

        int res = -1;
        List<Integer> l = Arrays.asList(2,3,5,4,1,0,0);
        for(int i=l.size()-1;i>0;i--) {
            if(l.get(i) > l.get(i-1)) {
                res = i;
            }
        }

        System.out.println(res);

        int nextMax = Integer.MAX_VALUE;
        int nextmaxIndex = -1;
        for(int i=res+1;i<l.size();i++) {
            int c = l.get(i);
            if(c > l.get(res) && c < nextMax) {
                nextMax = c;
                nextmaxIndex = i;
            }
        }

        swap(res,nextmaxIndex,l);

        System.out.println(nextMax);

        System.out.println(l);

        reverse(res+1, l);

        System.out.println(l);


    }

    private static void swap(int i, int j, List<Integer> list) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    private static void reverse(int s, List<Integer> list) {
        int j = list.size()-1;
        while(s < j) {
            swap(s, j, list);
            s++;
            j--;
        }
    }


}
