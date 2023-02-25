import java.util.ArrayList;

public class SubSequenceSumCount {

    static int sum = 5;
    static int[] array = {1,3,2,1,5};

    public static void main(String[] args) {
        System.out.println("Count :: "+ printSubSeq(0,new ArrayList<>(),0));
    }

    private static int printSubSeq(int ind, ArrayList<Integer> ds, int s) {
        if (ind >= array.length) {
            if (s == sum) {
                return 1;
            }
            return 0;
        }
        ds.add(array[ind]);
        s+=array[ind];
        int l = printSubSeq(ind+1, ds, s);
        ds.remove(Integer.valueOf(array[ind]));
        s-=array[ind];
        int r = printSubSeq(ind+1, ds, s);
        return l+r;
    }
}
