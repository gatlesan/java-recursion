import java.util.ArrayList;

//concept pick and not pick
//arraylist needs an object to remove the element therefore using wrapper object for int
public class SubSeqPrintAllUniComb {
    static int[] array = {3,2,1};

    public static void main(String[] args) {
        populate(0, new ArrayList<>());
    }

    private static void populate(int i, ArrayList<Integer> ds) {
        if(i >= array.length) {
            System.out.println(ds);
            return;
        }
        ds.add(array[i]);
        populate(i+1, ds);
        //remove is an overloaded method which takes Object(need wrapper object for the same)
        ds.remove(ds.indexOf(array[i]));
        populate(i+1, ds);
    }
}
