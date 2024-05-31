package striver_sheet.binary_search;

import java.util.List;

public class BinarySearchFindOneNonRepeatingNumber {

    public static void main(String[] args) {

        //List<Integer> list = List.of(1,1,2,2,3,3,4,5,5,6,6);
        List<Integer> list = List.of(1, 1, 3, 5, 5);
        System.out.println(find(0, list.size() - 1, list));
    }

    private static int find(int s, int e, List<Integer> list) {

        if (s > e) {
            return 0;
        }

        if (s == e) {
            return 0;
        }

        int left = 0;
        int right = 0;

        int m = (s + e) / 2;
        if ((m > 1 && list.get(m) != list.get(m - 1)) && (m < list.size() - 1 && list.get(m) != list.get(m + 1))) {
            return list.get(m);
        }

        left = find(s, m, list);
        right = find(m + 1, e, list);
        return left != 0 ? left : right != 0 ? right : 0;
    }


    // *** Using BS without recursion ***
    // *** How to break in to left and right sub-problems? ***
    // *** Intuition is for a given even index i the i and i+1 will be same
    // *** for a odd index i % 2 == 1 i and i-1 will for any of this eliminate left that is s = m+1
    // *** or else eliminate right that is e = m-1
    // *** start the iteration from 1 to n-2 and have the edge case for first and last element
    // *** also for n=1 return the same element
    // TC: O(logN), N = size of the given array.
}
