package arrays;

import java.util.Arrays;
import java.util.List;

public class InsertionSortPart1 {

    public static void main(String[] args) {

        //insertion sort for one element towards the end which is not sorted

        List<Integer> list = Arrays.asList(1,2,4,5,8);
        int lastIndex = list.size()-1;
        int temp = list.get(lastIndex);
        int i = lastIndex-1;
        while(i>=0 && list.get(i)>temp ) {
            list.set(lastIndex, list.get(i));
            print(list);
            i--;
            lastIndex--;
        }
        list.set(i+1,temp);
        print(list);
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
