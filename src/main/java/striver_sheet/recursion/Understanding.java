package striver_sheet.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Understanding {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,3);
        print(list, 0, new ArrayList<>());
    }


    //*** Careful with variables inside the recursion calls
    //*** 1. when val is added to memo this needs to be removed for non pick call...
    //*** 2. Do not do i=i+1 this is incr by 1 for the next call and also do not use i-- or i++
    //*** 3. remember to use memo.remove(memo.indexOf) remove requires the index...
    private static void print(List<Integer> list, int i, List<Integer> memo) {

        if(i > list.size()-1) {
            System.out.println(memo);
            return;
        }

        int val = list.get(i);
        memo.add(val);
        print(list,i+1,memo);
        memo.remove(memo.indexOf(val));
        print(list,i+1,memo);

    }
}
