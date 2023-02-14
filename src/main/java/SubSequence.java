import java.util.ArrayList;

public class SubSequence {

    static int arrlen = 0;
    static int[] array = {3, 2, 1};

    public static void main(String[] args) {
        arrlen = array.length;
        printSubSeq(0, new ArrayList<>());
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
