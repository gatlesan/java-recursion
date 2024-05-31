package striver_sheet.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeOverlappingSubArray {


    //time complexity O(n log n) on average for Collections.sort
    //O(n) for the for loop
    public static void main(String[] args) {

        //List<List<Integer>> list = Arrays.asList(Arrays.asList(2,6),Arrays.asList(1,6),Arrays.asList(1,3),Arrays.asList(8,10));
        //List<List<Integer>> list = Arrays.asList(Arrays.asList(1,4),Arrays.asList(4,5));
        List<List<Integer>> list = Arrays.asList(Arrays.asList(1, 3),
                Arrays.asList(2, 6),
                Arrays.asList(8, 9),
                Arrays.asList(9, 11),
                Arrays.asList(8, 10),
                Arrays.asList(2, 4),
                Arrays.asList(15, 18),
                Arrays.asList(16, 17));
        Collections.sort(list, (list1, list2) -> {
            if (list1.get(0) == list2.get(0)) {
                return list1.get(1).compareTo(list2.get(1));
            } else {
                return list1.get(0).compareTo(list2.get(0));
            }
        });
        System.out.println(list);

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (res.isEmpty()) {
                res.add(list.get(i));
            } else if (list.get(i).get(0) <= res.get(res.size() - 1).get(1)) {
                if (list.get(i).get(1) > res.get(res.size() - 1).get(1)) {
                    res.set(res.size() - 1, Arrays.asList(res.get(res.size() - 1).get(0), list.get(i).get(1)));
                }
            } else {
                res.add(list.get(i));
            }
        }
        System.out.println(res);
    }
}
