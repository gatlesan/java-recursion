package striver_sheet.linked_list;

import java.util.Arrays;
import java.util.List;

public class RemoveDuplicatesInPlace {

    public static void main(String[] args) {

        //arr[1,1,2,2,2,3,3] is a sorted array ..
        //BF: use HashSet

        //optimal using two pointer

        List<Integer> list = Arrays.asList(1,1,2,2,3,3);
        int i = 0;
        int j = 1;

        while(j < list.size()) {
            if(list.get(i) != list.get(j)) {
                //i = i+1;
                list.set(++i, list.get(j));
            }
            j++;
        }

        System.out.println(list.subList(0, i+1));
    }
}
