import java.util.ArrayList;

public class SubSequenceSum {
    static int sum = 2;
    static int[] array = {1, 3, 1, 2, 2};

    public static void main(String[] args) {
        printSubSeq(0, new ArrayList<>(), 0);
    }

    //same pattern but trick is to return boolean when given sum is found
    private static boolean printSubSeq(int ind, ArrayList<Integer> ds, int s) {

        if (ind >= array.length) {
            if (s == sum) {
                printArray(ds);
                return true;
            }
            return false;
        }

        ds.add(array[ind]);
        s += array[ind];
        if (printSubSeq(ind + 1, ds, s))
            return true;
        ds.remove(Integer.valueOf(array[ind]));
        s -= array[ind];
        printSubSeq(ind + 1, ds, s);
        return false;
    }

    private static void printArray(ArrayList<Integer> arr) {
        System.out.println(arr);
    }
}
