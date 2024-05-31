package subseq_dp;

import java.util.ArrayList;

public class SubSeqMinAbsDiff {
    public static void main(String[] args) {

        int[] a = {3,2,7};
        int totalSum = 0;
        for (int i=0; i< a.length; i++) {
            totalSum+=a[i];
        }
        System.out.println("total sum "+totalSum);
        ArrayList<Integer> sumArr = new ArrayList<>();
        findAll(0, 0, a, sumArr, a.length);
        int minSum = Integer.MAX_VALUE;
        for (int i=0; i< sumArr.size(); i++) {
            int diff = Math.abs(sumArr.get(i) - Math.abs(totalSum - sumArr.get(i)));
            minSum = Math.min(diff, minSum);
        }
        System.out.println(sumArr);
        System.out.println(minSum);
    }

    private static void findAll(int ind, int sum, int[] a, ArrayList<Integer> sumArr, int len) {

        if(ind == len) {
            sumArr.add(sum);
            return;
        }
        findAll(ind + 1, sum + a[ind], a, sumArr, len);
        findAll(ind + 1, sum, a, sumArr, len);
    }
}
