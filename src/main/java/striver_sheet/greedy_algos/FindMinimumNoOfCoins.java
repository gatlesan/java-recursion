package striver_sheet.greedy_algos;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindMinimumNoOfCoins {


    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 5, 10, 20, 50, 100, 500, 1000);
        Collections.sort(list, (i, j) -> {
            if (i > j) {
                return -1;
            } else if (i < j) {
                return 1;
            } else {
                return 0;
            }
        });

        System.out.println(list);

        System.out.println(findMinChange(list, 70));
    }

    private static int findMinChange(List<Integer> list, int val) {

        //*** looks simple but bit tricky
        //*** always remember to sort in desc order ...
        //*** pro-tip for logic building use for loop for one pointer and while for two pointers

        int changeCount = 0;
        for(int i=0;i<list.size();i++) {
            if(list.get(i) <= val) {
                val = val - list.get(i);
                changeCount++;
                if(val == 0) {
                    return changeCount;
                }
            }
        }
        return changeCount;
    }
}
