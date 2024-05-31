package striver_sheet.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeTwoSortedNoExtraSpace {


    // todo yet to solve it ....
    public static void main(String[] args) {

     /*   List<Integer> list1 = Arrays.asList(1,4,8,10);
        List<Integer> list2 = Arrays.asList(2,3,9);*/

        List<Integer> list1 = Arrays.asList(1, 3, 5, 7);
        List<Integer> list2 = Arrays.asList(0, 2, 6, 8, 9);

        // two pointers last of list1 and first of list2
        // sort list1 and list2

    /*    int l = list1.size()-1;
        int f = 0;
        while(l >= 0 && f < list2.size()) {
            if(list1.get(l) > list2.get(f)) {
                swap(l, list1, f, list2);
                l--;
                f++;
            } else {
                //no more iterations needed
                break;
            }
        }
        Collections.sort(list1);
        Collections.sort(list2);

        System.out.println(list1);
        System.out.println(list2);*/

        mergeUsingGapPointer(list1, list2);
        System.out.println(list1);
        System.out.println(list2);
    }

    private static void swap(int i, List<Integer> list1, int j, List<Integer> list2) {
        int temp = list1.get(i);
        list1.set(i, list2.get(j));
        list2.set(j, temp);
        System.out.println(list1+" "+list2);
    }

    //Gap method is taken from shell sorting, uses knuth sequence
    private static void mergeUsingGapPointer(List<Integer> list1, List<Integer> list2) {

        int size = list1.size() + list2.size();
        //*** Important when dealing with double divide by 2.0 or else it will give 4
        int gap = (int) Math.ceil(size / 2.0);

        int lv = 0;
        int rv = 0;
        int s1 = list1.size();
        int s2 = list2.size();
        int totalSize = s1 + s2;
        while (gap > 0) {
            int l = 0;
            int r = 0;
            // Important do not reduce the r value and r++ is ending in infinite loop
            while (r < totalSize) {

                if (r > s1 - 1) {
                    rv = list2.get(r - s1);
                } else {
                    rv = list1.get(r);
                }

                if (l > s1 - 1) {
                    lv = list2.get(r - s1);
                } else {
                    lv = list1.get(l);
                }

                if (r > (s1 - 1) && l > (s1 - 1)) {
                    swap(r-s1,list2,l-s1, list2);
                } else if(r > (s1 - 1)) {
                    swap(r-s1,list2,l, list1);
                }


                System.out.println(lv + " " + rv);
                l++;
                r++;
            }


            //** Important due to ceil the gap will always be 1 if not checked before the operation
            if (gap == 1)
                break;
            gap = (int) Math.ceil(gap / 2.0);
        }
    }
}
