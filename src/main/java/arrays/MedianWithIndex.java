package arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


// It works but it is not the best solution.
// And, times out for large inputs.
// Alternatively, we can use the following approach:
// PriorityQueue to find median
public class MedianWithIndex {
    public static void main(String[] args) {
        List<Integer> expenditure = Arrays.asList(2,3,4,2,3,6,8,4,5,10);
        int d =5;
        int n =expenditure.size();
        int c = 0;
        int j =0;
        if(n <= d+1) {
            System.out.println("Notifications "+c);
        } else {
            for(int i=0; i<n && (i+d)<n; i++) {
                j = i+d;
                if(expenditure.get(j) >= (2*getMedian(i, j, expenditure))) {
                    c++;
                }
            }

        }
        System.out.println(expenditure);
        System.out.println("Notifications "+c);
    }

    private static int getMed(int s, int e, List<Integer> list) {

        int size = (e-s);
        System.out.println("s "+s+" e "+e+" size "+size);
        if(size%2 == 0) {
            return (list.get((size/2)+s) + ((list.get(size/2)-1)+s)/2)/2;
        } else {
            return list.get((size/2)+s);
        }
    }


    private static int getMedian(int s, int e, List<Integer> list) {

        if(s == 0){
            List<Integer> exp = list.subList(s, e);
            Collections.sort(exp);
            return getMed(s,e,exp);
        } else {
            int lastIndex = e-1;
            int temp = list.get(lastIndex);
            int i = lastIndex-1;
            while(i>=s && list.get(i)>temp) {
                list.set(lastIndex, list.get(i));
                lastIndex--;
                i--;
            }
            list.set(i+1, temp);
            System.out.println(list);
            return getMed(s,e,list);
        }
    }
}
