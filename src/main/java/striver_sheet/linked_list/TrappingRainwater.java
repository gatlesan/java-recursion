package striver_sheet.linked_list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrappingRainwater {


    public static void main(String[] args) {

        //*** Given an array plot a bar chart which will plot the areas where water could be trapped
        //*** height= [0,1,0,2,1,0,1,3,2,1,2,1]
        //*** BF: formula can be Min(maxLeft(i), maxRight(i))-a[i]  ... from 0 to n-1 TC: O(n^2) as it has to find maxLeft and maxRight


        //Optimal: doing pre-computation and building prefixMax and suffixMax arrays
        //prefixMax and suffixMax arrays

        List<Integer> list = Arrays.asList(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1);
        System.out.println(trapWater(list));

        System.out.println(trapWaterOptimal(list));

    }


    //*** Use arrays for preMax and suffixMax list as in case of suffixMaxList
    //*** you cannot save values form size-1 index
    //O(n) + O(n) + O(n)
    private static int trapWater(List<Integer> list) {


        int preMax = 0;
        int[] preMaxList = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            preMax = list.get(i) > preMax ? list.get(i) : preMax;
            preMaxList[i] = preMax;

        }

        int suffixMax = 0;
        int[] suffixMaxList = new int[list.size()];
        for (int i = list.size() - 1; i >= 0; i--) {
            suffixMax = list.get(i) > suffixMax ? list.get(i) : suffixMax;
            suffixMaxList[i] = suffixMax;
        }

        int trapCount = 0;
        for (int i = 0; i < list.size(); i++) {
            trapCount += (Math.min(preMaxList[i], suffixMaxList[i]) - list.get(i));
        }

        return trapCount;
    }

    //*** Optimal - two pointer
    //*** Intuition - when l < r sloop is left water can't be trapped - update leftMax if a[i] is greater.
    //*** If r > l check if r > rightMax then only water can be trapped or not

    private static int trapWaterOptimal(List<Integer> list) {

        int water = 0;
        int leftMax = 0;
        int rightMax = 0;
        int l = 0;
        int r = list.size() - 1;
        while(l < r) {
            if(list.get(l) < list.get(r)) {
                if(list.get(l) > leftMax) {
                    leftMax = list.get(l);
                } else {
                    water+= leftMax-list.get(l);
                }
                l++;
            } else {
                if(list.get(r) > rightMax) {
                    rightMax = list.get(r);
                } else {
                    water+= rightMax-list.get(r);
                }
                r--;
            }
        }
        return water;
    }
}
