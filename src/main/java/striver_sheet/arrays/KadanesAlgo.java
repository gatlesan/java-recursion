package striver_sheet.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KadanesAlgo {


    // A subarray with a sum less than 0 will always reduce our answer and so this type of subarray cannot be a part of the subarray with maximum sum.
    // Also handle sum of empty sub array which is 0
    public static void main(String[] args) {

        List<Integer> l = Arrays.asList(1, 2, 3, 4, -6);
        List<Integer> l2 = Arrays.asList(-4, -3, -1, -6);
        List<Integer> l1 = Arrays.asList(-2, -3, 4, -1, -2, 1, 5, -3);
        int s = 0;
        int e = 0;
        int max = l.get(0);
        int sum = 0;
        int start = 0;


        // memo - remember the code
        // take
        // if sum > max = sum
        // if sum < 0, sum =0;
        for (int i = 0; i < l.size(); i++) {
            if (sum == 0) {
                start = i;
            }
            sum = sum + l.get(i);
            if (sum > max) {
                max = sum;
                s = start;
                e = i;
            }
            if (sum < 0) {
                sum = 0;
            }
        }

        System.out.println(s + " " + e);
        System.out.println(max);

        practise();

    }


    //practise
    // Also handle sum of empty sub array which is 0
    private static void practise() {

        List<Integer> list1 = Arrays.asList(-2, -3, 4, -1, -2, 1, 5, -3);
        List<Integer> list = Arrays.asList(-4, -3, -1, -6);
        int s = 0;
        int m = 0;
        //** remember this...
        //if(s < 0) reset s = 0;
        for (int i = 0; i < list.size(); i++) {
            s+=list.get(i);
            if(s < 0) {
                s = 0;
            }
            m = m > s ? m : s;
        }
        System.out.println(m);
    }
}
