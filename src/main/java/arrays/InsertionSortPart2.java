package arrays;

import java.util.Arrays;
import java.util.List;

public class InsertionSortPart2 {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(3,4,7,5,6,2,1);

        // as per Q's scan from left to right
        // first element is already sorted
        // start outer loop from 1 to n-1
        // take i element as temp and move the elements greater than it to right
        // j = i-1 ... 0
        // a[j] > temp a[j+1] = a[j];


        for(int i=1;i<list.size();i++) {

            int temp = list.get(i);
            int j = i-1;

            while(j>=0 && temp<list.get(j)) {
                list.set(j+1, list.get(j));
                j--;
            }
            list.set(j+1, temp);
            print(list);
        }

    }

    private static void print(List<Integer> list) {

        for(int i=0;i<list.size();i++) {
            System.out.print(list.get(i));
            if(i != list.size()-1) {
                System.out.print(" ");
            }
        }
        System.out.println();

    }
}
