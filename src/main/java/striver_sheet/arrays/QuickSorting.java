package striver_sheet.arrays;

import java.util.Arrays;
import java.util.List;

public class QuickSorting {


    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(4, 1, 3, 6, 8, 2, 5);
        System.out.println(list);
        sort(0, list.size() - 1, list);
        System.out.println(list);
    }


    private static void sort(int low, int high, List<Integer> list) {

        if (high <= low) {
            return;
        }

        int pi = partition(low, high, list);
        sort(low, pi - 1, list);
        sort(pi + 1, high, list);

    }

    private static int partition(int low, int high, List<Integer> list) {


        int i = low + 1;
        int j = high;
        while (i <= j) {
            int pVal = list.get(low);
            while (i <= high && list.get(i) <= pVal) {
                i++;
            }
            while (j >= low && list.get(j) > pVal) {
                j--;
            }
            if (i < j) {
                swap(i, j, list);
            }
        }
        swap(low, j, list);
        return j;
    }

    private static void swap(int i, int j, List<Integer> list) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
