package striver_sheet.binary_search;

import java.util.Arrays;
import java.util.List;

public class BinarySearch {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        for (int in : list) {
            System.out.println(in);
            // System.out.println(binarySearch(0, list.size() - 1, list, in));
            System.out.println(binarySearchNoRecursion(list, in));
        }
    }

    private static boolean binarySearch(int s, int e, List<Integer> list, int target) {

        if (s > e) {
            return false;
        }

        if (s == e) {
            return list.get(s) == target;
        }

        //remember (s+e)/2 is the midpoint as we are passing in the indexes
        int m = (s + e) / 2;
        boolean left = false;
        boolean right = false;
        if (target <= list.get(m)) {
            left = binarySearch(s, m, list, target);
        } else if (target > list.get(m)) {
            right = binarySearch(m + 1, e, list, target);
        } else if (target == list.get(m)) {
            return true;
        }
        return left || right;
    }

    private static boolean binarySearchNoRecursion(List<Integer> list, int target) {

        int s = 0;
        int e = list.size() -1 ;
        while (s <= e) {
            int m = (s + e) / 2;
            if (target == list.get(m)) {
                return true;
            } else if (target < list.get(m)) {
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return false;
    }
}
