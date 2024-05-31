package tmp;

import java.util.ArrayList;
import java.util.List;

public class Tmp {

    public static void main(String[] args) {

        // int[] a = {1,2,3};
        // fun(0, a, new ArrayList<>());
        int[][] dp = new int[3][3];
        dp[0][0] = -1;
        System.out.println(dp[0][0]);
        System.out.println(dp[0][1]);
    }


    private static void fun(int i, int[] a, List<Integer> res) {

        // when starting with 0 always use len-1
        if(i > a.length - 1) {
            System.out.println(res);
            return;
        }

        res.add(a[i]);
        fun(i+1, a, res);
        //list remove function needs an index remember res.indexOf()
        res.remove(res.indexOf(a[i]));
        fun(i+1, a, res);


    }
}
