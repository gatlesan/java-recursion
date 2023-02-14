import java.util.ArrayList;

public class SubSequence {

    static int arrlen = 0;
    static int[] array = {3, 2, 1};

    public static void main(String[] args) {
        arrlen = array.length;
        printSubSeq(0, new ArrayList<>());
        //want to use arraylist as it gets bit complicated to
        //handle array needs default size and also have default zeros
        int[] t = new int[arrlen];
    }

    private static void printSubSeq(int ind, ArrayList<Integer> a) {

        if (ind >= arrlen) {
            printArray(a);
            return;
        }
        printSubSeq(ind + 1, addElement(array[ind], a));
        printSubSeq(ind + 1, removeElement(array[ind], a));

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
