package striver_sheet.arrays;

import java.util.Arrays;
import java.util.List;

public class DutchNationFlagAlgo {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(0,1,1,0,1,2,1,2,0,0);
        List<Integer> list1 = Arrays.asList(0,1,2,0,1);
        int l = 0;
        int m = 0;
        int h = list.size()-1;

        while(m <= h) {
            if(list.get(m) == 0) {
                swap(m,l,list);
                l++;
                m++;
            }
            else if(list.get(m) == 1) {
                m++;
            }
            else if(list.get(m) == 2) {
                swap(m,h,list);
                h--;
            }
            System.out.println(list);
        }



        System.out.println(list);


    }

    private static void swap(int i, int j, List<Integer> list) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
