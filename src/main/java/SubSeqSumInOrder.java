import java.util.*;

public class SubSeqSumInOrder {

    public static void main(String[] args) {
        int[] arr = {2, 3};
        System.out.println(findSubSeqSums(arr));
    }

    private static List<Integer> findSubSeqSums(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        subSeqSum(0, 0, ans, arr);
        System.out.println(ans);
        // sort is needed here as recursion output is not in asc order
        // Collections.sort --> Arrays.sort --> Timsort
        // O(2 pow n)+ O(nlog(n))
        // Collections.sort(ans);
        Arrays.sort(ans.toArray());
        return ans;
    }

    private static void subSeqSum(int ind, int sum, List<Integer> list, int[] arr) {

        if (ind >= arr.length) {
            list.add(sum);
            return;
        }

        sum += arr[ind];
        subSeqSum(ind + 1, sum, list, arr);
        sum -= arr[ind];
        subSeqSum(ind + 1, sum, list, arr);
    }
}
