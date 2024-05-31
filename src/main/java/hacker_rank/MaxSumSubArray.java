package hacker_rank;

import java.util.Arrays;
import java.util.List;

public class MaxSumSubArray {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(2,-1,2,3,4,-5);
        List<Integer> list1 = Arrays.asList(-2,-3,-1,-4,-6);
        System.out.println(maxSumSubArray(list));
        //System.out.println(findMaxSubArray(Arrays.asList(-2,-3,4,-1,-2,1,5,-3)));
        //System.out.println(findMaxSubArray(Arrays.asList(1,2,3,4)));
        System.out.println(findMaxSubArray(Arrays.asList(2,-1,2,3,4,-5)));
        System.out.println(findMaxSubArray(list1));
        System.out.println(findMaxSubArray(Arrays.asList(-100,-1)));

    }

    // {1,2,3,4,-5}
    // two pointers i,j will select the range
    // sum between i and j will be the max sum
    // Always use Integer.MIN_VALUE as the initial value
    // consider single element k<j not k<=j
    private static int maxSumSubArray(List<Integer> arr) {

        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.size();i++){
            for(int j=i+1;j<arr.size();j++){
                int sum=0;
                for(int k=i;k<j;k++){
                    sum+=arr.get(k);
                }
                max = Math.max(max,sum);
            }
        }
        return max;
    }

    // Kadane's Algorithm
    // {-2,-3,4,-1,-2,1,5,-3}
    // {1,2,3,4}
    private static int findMaxSubArray(List<Integer> arr) {
            int max = Integer.MIN_VALUE;
            int sum = 0;
            for(int i=0; i<arr.size(); i++) {
                int c = arr.get(i);
                if (sum + c >= max) {
                    sum = sum + c;
                    max = sum;
                } else if (sum + c < 0) {
                    sum = 0;
                    if(c >= max) {
                        max = c;
                    }
                } else {
                    sum = sum + c;
                }
            }
            return max;
    }
}
