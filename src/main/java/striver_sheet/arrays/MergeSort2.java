package striver_sheet.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort2 {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(3,2,1,4,5);
        divide(0, list.size()-1, list);
        System.out.println(list);

    }


    //** Important in this approach we take e = size-1 and divide --> (0, 4) --> (0, 2) (3, 4) --> (s,m) (m+1, e)
    // Due to m+1 in the recursion s > e return terminating condition
    // In this variation left and right divide will just return out of recursion and will not return any List
    private static void divide(int s, int e, List<Integer> list) {

        if(e-s == 0) {
            return;
        }
        int m = (s+e)/2;
        divide(s, m, list);
        divide(m+1, e, list);
        conquer(s, m, e, list);
    }

    private static List<Integer> conquer(int s, int m, int e, List<Integer> list) {

        List<Integer> temp = new ArrayList<>();
        int i = s;
        int j = m+1;

        while(i <= m && j <= e) {
            if(list.get(i) <= list.get(j)) {
                temp.add(list.get(i));
                i++;
            } else {
                temp.add(list.get(j));
                j++;
            }
        }

        //remaining elements in left array
        while(i<=m) {
            temp.add(list.get(i));
            i++;
        }

        while(j<=e) {
            temp.add(list.get(j));
            j++;
        }

        //*** Transfer the elements from temp to list
        //*** temp will occupy the elements from 0...e
        //*** k-s
        for(int k=s;k<=e;k++) {
            list.set(k, temp.get(k-s));
        }

        //Alternate
        /*int t =0;
        int k =s;
        while(t < temp.size()) {
            list.set(k, temp.get(t));
            t++;
            k++;
        }*/

        System.out.println(temp);
        return temp;

    }
}
