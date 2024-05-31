package hacker_rank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DivideConquer {

    public static void main(String[] args) {

        List<Integer> a = Arrays.asList(3,1,5,2,6,4);
        System.out.println(divide(0, a.size(), a));
    }


    // 3,1,2,4
    private static List<Integer> divide(int s, int e, List<Integer> a) {

        // ** divide till only one element in the list...
        if(e-s == 1) {
            System.out.println(a.get(s));
            //** remember to send as Arrays asList **
            return Arrays.asList(a.get(s));
        }
        //** remember e+s not e-s **
        int m = (e+s) / 2;
        List<Integer> l = divide(s, m, a);
        List<Integer> r = divide(m, e, a);
        return merge(l, r);
    }

    private static List<Integer> merge(List<Integer> l, List<Integer> r) {
        System.out.println(l + " " + r);
        List<Integer> m = new ArrayList<>();
        int i = 0, j = 0;
        while(i < l.size() && j < r.size()) {
            if(l.get(i) < r.get(j)) {
                m.add(l.get(i));
                i++;
            } else {
                m.add(r.get(j));
                j++;
            }
        }

        // copy the remaining left elements
        while (i < l.size()) {
            m.add(l.get(i));
            i++;
        }

        // copy the remaining right elements
        while (j < r.size()) {
            m.add(r.get(j));
            j++;
        }

        // return copy of m
        return m;
    }
}
