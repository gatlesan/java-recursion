package dp;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class LongestCommonSubSeqTab {

    public static void main(String[] args) {

        int[] a = {10, 9, 0, 2, 5, 3, 7, 101, 18};
        int n = a.length;
        int[] dp = new int[n];
        for(int i = 0 ; i < n; i++) {
            dp[i] = 1;
        }


        for(int i = 0; i < n ; i ++) {
            for(int j = 0; j < i; j++) {
                if(a[i] > a[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;
        for(int k = 0; k < n ; k++) {
            if(dp[k] > max)
                max = dp[k];
        }

        System.out.println(max);
    }
}
