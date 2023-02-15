import java.util.ArrayList;

public class SubSequenceSum {

    static int arrlen = 0;
    static int sum = 1;
    static int[] array = {3, 2, 1};

    public static void main(String[] args) {
        arrlen = array.length;
        printSubSeq(0, new ArrayList<>(), 0);
        //want to use arraylist as it gets bit complicated to
        //handle array needs default size and also have default zeros
        int[] t = new int[arrlen];
    }

    //same pattern but trick is to return boolean when given sum is found
    private static boolean printSubSeq(int ind, ArrayList<Integer> a, int s) {

        if (s == sum) {
            printArray(a);
            return true;
        }
        if (ind >= arrlen)
            return false;
        if (printSubSeq(ind + 1, addElement(array[ind], a), s + array[ind]))
            return true;
        // on the right side of RT do not need to do s-array[ind] as it gives incorrect sum
        printSubSeq(ind + 1, removeElement(array[ind], a), s);
        return false;
    }

    private static void printArray(ArrayList<Integer> arr) {
        System.out.println(arr);
    }

    // add element better to use custom add as a.add has side effects
    private static ArrayList<Integer> addElement(int element, ArrayList<Integer> list) {
        ArrayList<Integer> listTemp = new ArrayList<>();
        for (int e : list) {
            if (e != element) {
                listTemp.add(e);
            }
        }
        listTemp.add(element);
        return listTemp;
    }

    // cannot remove element a.remove(i) which takes index but not the element to remove
    private static ArrayList<Integer> removeElement(int element, ArrayList<Integer> list) {
        ArrayList<Integer> listTemp = new ArrayList<>();
        for (int e : list) {
            if (e != element) {
                listTemp.add(e);
            }
        }
        return listTemp;
    }
}
