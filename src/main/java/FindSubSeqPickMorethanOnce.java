import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindSubSeqPickMorethanOnce {

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
            List<Integer> temp = new ArrayList<>(ds);
            ans.add(temp);
            return;
        }

        if (ind >= array.length) {
            return;
        }

        if (s < sum) {
            //keep pick and not pick within this block
            ds.add(array[ind]);
            s += array[ind];
            find(ind, ds, s, ans);
            ds.remove(Integer.valueOf(array[ind]));
            s -= array[ind];
        }
        find(ind + 1, ds, s, ans);
    }
}
