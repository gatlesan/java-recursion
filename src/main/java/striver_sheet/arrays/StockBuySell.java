package striver_sheet.arrays;

import java.util.Arrays;
import java.util.List;

public class StockBuySell {
    public static void main(String[] args) {


        //Brute force O(n^2) compare each element with n+1
        // find the min linearly and maintain max with diff



        List<Integer> list1 = Arrays.asList(2,2,1,9,4,2,10);
        List<Integer> list = Arrays.asList(7,1,5,3,6,4);
        int min = list.get(0);
        int max = Integer.MIN_VALUE;
        for(int i=0;i<list.size();i++) {
            int price  = list.get(i);
            if(price <= min) {
                min = price;
            }
            if(price > min) {
                int diff = price - min;
                max = diff > max ? diff : max;
            }
        }
        System.out.println(max);
    }
}
