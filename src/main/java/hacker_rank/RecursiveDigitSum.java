package hacker_rank;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RecursiveDigitSum {

    public static void main(String[] args) {

        int n = 100000;
        int app = n-1;
        String s = "861568688536788";
        StringBuilder sb = new StringBuilder(s.trim());
        while(app >= 1) {
            sb.append(s);
            app--;
        }
        System.out.println(sb.toString());
        List<Integer> a = Arrays.stream(sb.toString().split("")).sequential().map(Integer::valueOf).collect(Collectors.toList());
        System.out.println(a);
        // int res = digitSum(a, a.size()-1);
        // System.out.println(res);

        int[] digits = sb.toString().chars().map(c -> c-'0').toArray();
        System.out.println(digitSum(digits));


    }
    // 129
    private static int digitSum(List<Integer> a, int i) {

        if(i == 0) {
            return a.get(0);
        }
        BigInteger sum = BigInteger.valueOf(a.get(i) + digitSum(a, i-1));
        List<Integer> arr = Arrays.stream(String.valueOf(sum).split("")).sequential().map(Integer::valueOf).collect(Collectors.toList());
        if(arr.size() > 1) {
            return digitSum(arr, arr.size()-1);
        } else {
            return arr.get(0);
        }

    }

    private static int digitSum(int[] a) {

        int sum = 0;
        do {
            for (int i = 0; i < a.length; i++) {
                sum += a[i];
            }
            a = String.valueOf(sum).chars().map(c -> c-'0').toArray();
        }while (sum > 9);

        return sum;

    }

}
