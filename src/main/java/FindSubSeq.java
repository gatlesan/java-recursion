import java.util.*;

public class FindSubSeq {

    static int[] array = {1, 1, 1, 2, 2};
    static int sum = 4;


    public static void main(String[] args) {

        // Using set as solution set must not contain duplicates
        Set<List<Integer>> ans = new HashSet<>();
        find(0, new ArrayList<>(), 0, ans);
        System.out.println(ans);
    }

    private static void find(int ind, List<Integer> ds, int s, Set<List<Integer>> ans) {

        if (s == sum) {
            // System.out.println(ds);
            //todo find a way to not do this
            //adding a ds to the ans is not enough as non pick will remove the elements from the ds
            //therefore created a new list from ds and added to the ans
            ans.add(new ArrayList<>(ds));
            return;
        }

        if (ind >= array.length) {
            return;
        }

        if (s < sum) {
            //keep pick and not pick within this block
            ds.add(array[ind]);
            s += array[ind];
            find(ind + 1, ds, s, ans);
            ds.remove(Integer.valueOf(array[ind]));
            s -= array[ind];
        }
        find(ind + 1, ds, s, ans);
    }
}
