package patterns.two_pointer;

public class NonDuplicate {


    public static void main(String[] args) {


        // int[] a = {3, 2, 3, 6, 3, 10, 9, 3};
        int[] a = {2, 11, 2, 2, 1};
        int key = 2;

        int nd = 0;
        for(int i=0;i<a.length;i++) {
            if(a[i] != key) {
                a[nd] = a[i];
                nd++;
            }
        }

        System.out.println(nd);
    }
}
