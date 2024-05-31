package striver_sheet.arrays;

import java.util.*;

public class TwoSum {


    // 1. hashmap O(n) SP: O(n)
    // 2. Sort and then two pointer approach until i>j
    public static void main(String[] args) {
        int t = 15;
        List<Integer> list = Arrays.asList(2,6,5,8,11);
        //using hashmap for index
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<list.size();i++) {
            map.put(list.get(i), i);
        }
        boolean res = false;
        int i1= -1;
        int i2= -1;
        for(int i=0;i<list.size();i++) {
            int diff = t-list.get(i);
            if(map.get(diff) != null) {
                res = true;
                i1 = i;
                i2 = map.get(diff);
                break;
            }
        }
        System.out.println(i1+" "+i2);
        System.out.println(res);

        System.out.println(findTwoSum(list,14));
    }

    //{2,5,6,8,11}
    private static boolean findTwoSum(List<Integer> arr, int t) {

        Collections.sort(arr);
        int i=0;
        int j=arr.size()-1;
        while(i<j) {
            if(arr.get(i)+arr.get(j) == t) {
                return true;
            } else if(arr.get(i)+arr.get(j) > t){
                j--;
            } else {
                i++;
            }
        }
        return false;
    }


}
