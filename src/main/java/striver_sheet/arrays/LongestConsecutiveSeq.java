package striver_sheet.arrays;

import java.util.*;

public class LongestConsecutiveSeq {


    public static void main(String[] args) {

        List<Integer> list1 = Arrays.asList(100,200,1,3,2,4);
        List<Integer> list = Arrays.asList(100,200,1,3,1,1,2,2,2,4);
        //O(nlog(n))
        Collections.sort(list);
        //[1, 2, 3, 4, 100, 200]
        int maxSeq = 0;
        int c=1;
        //O(n)
        for(int i=1;i<list.size();i++) {
            //this does not handle duplicates
            if(list.get(i) == list.get(i-1)+1) {
                c+=1;
                maxSeq = c > maxSeq? c : maxSeq;
            } else {
                c=1;
            }
        }
        System.out.println(maxSeq);

        List<Integer> l = Arrays.asList(100,102,100,101,101,4,3,2,3,2,1,1,1,2,5);
        //System.out.println(findLCS(l));

        //Better...
        //using HashSet does not provide a guarantee to sort the data, TreeSet does provide the
        Set<Integer> s = new HashSet<>();
        //remove duplicates and orders the elements then just O(n) to find the longest seq
        s.addAll(l);
        System.out.println(s);

        //optimal
        List<Integer> ll = Arrays.asList(102,4,100,1,1,101,3,2,2);
        System.out.println(findLCSOptimal(ll));
    }


    private static int findLCS(List<Integer> list) {
        Collections.sort(list);
        int max = 1;
        int c = 0;
        int i=1;
        while(i<list.size()) {
            while(list.get(i) == list.get(i-1)) {
                i++;
            }
            if(list.get(i-1)+1 == list.get(i)){
                c+=1;
                max = max > c ? max : c;
            } else {
                c=0;
            }
            i++;
        }
        return max;
    }

    //O(n)
    //prerequisite no duplicates use set
    //can't get element from HashSet
    //create new list from hashset
    //
    private static int findLCSOptimal(List<Integer> list) {
        list = new ArrayList<>(new HashSet<>(list));
        int i = 0;
        int m = 1;
        int c = 0;
        while(i<list.size()) {
            int e = list.get(i);
            if (!list.contains(e - 1)) {
                while (list.contains(e++)) {
                    c++;
                }
                m = m > c ? m : c;
            }
            i++;
            c = 0;
        }
        return m;
    }
}
