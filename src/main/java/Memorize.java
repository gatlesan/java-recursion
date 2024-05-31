import java.util.*;

public class Memorize {


    public static void main(String[] args) {


        int[] a = {1, 3, 5, 2, 4};
        Arrays.sort(a); // return void...
        for (int i : a) {
            System.out.println(i);
        }

        List<Integer> memo = Arrays.asList(1, 2, 3, 4);
        Collections.reverse(memo);
        System.out.println(memo);

        List<List<Integer>> mat = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );

        System.out.println(mat);
        Collections.reverse(mat.get(0));
        System.out.println(mat);

        boolean res = bst(0, a.length-1, 6, a);
        System.out.println(res);

        // memoize a 2d matrix result
        //int[][] memo = new int[a.length+1][a.length+1];




    }

    private static boolean bst(int i, int j, int target, int[] arr) {

        if(i > j) {
            return false;
        }

        int m = (i + j) / 2;
        if(arr[m] == target) {
            return true;
        } else if(arr[m] > target) {
            if(bst(i, m-1, target, arr)) {
                return true;
            }
        } else {
            if(bst(m+1, j, target, arr)) {
                return true;
            }
        }
        return false;
    }
}
