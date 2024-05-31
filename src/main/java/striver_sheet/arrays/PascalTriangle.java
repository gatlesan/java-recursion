package striver_sheet.arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public static void main(String[] args) {

        // 1. find the element at given r and c ---------------> ncr = n! / (r! * (n-r)!) --- r-1C(c-1)
        //2. print the given row in pascal triangle
        //3. print the pascal triangle for given number of rows

        System.out.println(findNCR(5,3));

        //print a given row in pascal triangle

        /*int r = 5; int c = r+1;
        for(int i=0;i<c;i++) {
            System.out.println(findNCR2(5,i));
        }*/


        int r = 5; int c = 5;
        List<List<Integer>> list = new ArrayList<>();
        //print pascal triangle
        for(int i=1;i<r;i++) {
            List<Integer> res = new ArrayList<>();
            for(int j=0;j<c;j++) {
                res.add(findNCR2(i,j));
            }
            list.add(res);
        }
        System.out.println(list);
    }

    private static int findNCR(int r, int c) {
        return getFact(r-1) / (getFact(c-1) * getFact(r-c));
    }

    // find ncr modification
    private static int findNCR2(int n, int r) {
        int res = 1;
        for(int i=0;i<r;i++) {
            res=res*(n-i)/(i+1);
        }
        return res;
    }

    private static int getFact(int n) {
        if(n<=1)
            return 1;
        return n * getFact(n-1);
    }
}
