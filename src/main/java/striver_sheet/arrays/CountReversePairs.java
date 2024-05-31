package striver_sheet.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountReversePairs {

    // Good for testing for recursion variable can exist outside the method execution/stack
    static int count = 0;

    // for i<j find a[i]>2*a[j]
    public static void main(String[] args) {

        //*** logic which can be applied before the merge of left and right sorted arrays
        //to get the count of elements satisfying the condition

//        List<Integer> leftArray = Arrays.asList(5,10,15,20);
//        List<Integer> rightArray = Arrays.asList(2,3,6,11);
//        List<Integer> leftArray = Arrays.asList(6,13,21,25);
//        List<Integer> rightArray = Arrays.asList(1,2,3,4,4,5,9,11,13);
        List<Integer> leftArray = Arrays.asList(12,19,25,40);
        List<Integer> rightArray = Arrays.asList(2,6,9);
        int i=0;int j=0;int c =0;

        // in merge sort right index will start with m+1 c+(j-(m+1))
        // s = m+1;
        int s = 0;

        while(i<leftArray.size()) {
            while(j < rightArray.size() && leftArray.get(i)>(2*rightArray.get(j))) {
                j++;
            }
            System.out.println(j);
            c = c+(j-s);
            i++;
        }

        System.out.println(c);
        System.out.println(i+" "+j);


        // List<Integer> arr = Arrays.asList(3,2,1,5,4);
        // List<Integer> arr = Arrays.asList(12,19,25,40,2,6,9);
        List<Integer> arr = Arrays.asList(12,19,25,40,2,6,9);
        int cc = divide(0,arr.size()-1,arr);
        System.out.println("final count "+cc);
        //System.out.println(count);

    }

    //******* i<j remember this ans is 10 if not would be 15 for Arrays.asList(12,19,25,40,2,6,9)
    private static int countReversePairs(int s, int m, int e, List<Integer> arr) {

        int i = s;
        int j = m+1;
        while(i<=m) {
            while(j<=e && arr.get(i)>2*arr.get(j)) {
                j++;
            }
            count= count+(j-(m+1));
            i++;
            System.out.println("count "+count);
        }
        return count;
    }


    //{3,2,1,5,4}
    private static int divide(int s, int e, List<Integer> arr) {

        int cnt = 0;

        if(e-s == 0) {
            return 0;
        }
        int m = (s+e)/2;
        cnt+= divide(s,m,arr);
        cnt+= divide(m+1,e,arr);
        cnt+= countReversePairs(s,m,e,arr);
        conquer(s,m,e,arr);
        return cnt;

    }

    //{1,2,3} {4,5}
    private static void conquer(int s, int m, int e, List<Integer> arr) {
        int i = s;
        int j = m+1;
        List<Integer> temp = new ArrayList<>();
        while(i<=m && j<=e) {
            if(arr.get(i) >= arr.get(j)) {
                temp.add(arr.get(j));
                j++;
            } else {
                temp.add(arr.get(i));
                i++;
            }
        }

        //copy the left elements
        while(i<=m) {
            temp.add(arr.get(i));
            i++;
        }

        while(j<=e) {
            temp.add(arr.get(j));
            j++;
        }

        //copy the elements from temp to arr
        for(int k=s;k<=e;k++) {
            arr.set(k, temp.get(k-s));
        }

        return;
    }
}
