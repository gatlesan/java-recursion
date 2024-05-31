package striver_sheet.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountInversionArray {

    public static void main(String[] args) {

        // Count Inversion array... {5,4,3,2,1}
        // Count is 10: --> 54, 53, 52, 51, ........
        // O(n^2) by comparing each element and counting if a[i] > a[j]
        // optimal --> merge sort

        //** Understand the sub problem...
        List<Integer> list1 = Arrays.asList(2,3,5,6);
        List<Integer> list2 = Arrays.asList(2,2,4,4,8);
        findCount(list1,list2);


        List<Integer> ll = Arrays.asList(5,4,3,2,1);
        System.out.println(divide(0, ll.size()-1, ll));




    }


    // Sub problem solve this first for understanding
    // 2 sorted arrays {2,3,5,6}, {2,2,4,4,8}
    // find the count of pairs where a[i] > a[j]
    // **** if at any point a[i] > a[j] all the elements on the left+1 are > a[j] as they are sorted *******
    // two pointer approach...

    private static void findCount(List<Integer> list1, List<Integer> list2) {
        int i =0;
        int j=0;
        int c=0;
        while(i < list1.size() && j < list2.size()) {
            if(list1.get(i) <= list2.get(j)) {
                i++;
            } else if(list1.get(i) > list2.get(j)) {
                c = c + (list1.size()-1) - i;
                c++;
                j++;
            }
        }
        System.out.println(c);
    }

    private static int divide(int s, int e, List<Integer> list) {

        int count = 0;
        if(e-s == 0) {
            return count;
        }
        int m = (s+e)/2;
        count+= divide(s, m, list);
        count+= divide(m+1, e, list);
        count+= conquer(s, m, e, list);
        return count;
    }

    private static int conquer(int s, int m, int e, List<Integer> list) {

        List<Integer> temp = new ArrayList<>();
        int count = 0;
        int i = s;
        int j = m+1;

        while(i <= m && j <= e) {
            if(list.get(i) <= list.get(j)) {
                temp.add(list.get(i));
                i++;
            } else {
                //*** from i at i>j it is clear that from i+1 to m all the greater so add them to the count
                count+=(m-i)+1;
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

        System.out.println(temp);
        return count;

    }


}
