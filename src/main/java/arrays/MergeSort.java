package arrays;

public class MergeSort {

    public static void main(String[] args) {


        // Divide and conquer
        // Recursion
        // splitting and merging
        // splitting is preliminary
        // Not an in place algorithm
        // uses extra memory for temp array during merging phase
        // O(nlogn) base 2 - log(n) because of splitting
        // stable


        //using System.arrayCopy
        //Remember length should be same in both the src and dest arrays
        /*int[] a = {1,2,3,4};
        int[] b = {1,2,0,0};
        System.arraycopy(a, 2, b, 2, 2);
        for(int i=0;i<b.length;i++) {
            System.out.print(b[i]);
        }*/

        int[] a = { 5,3,8,1 };
        split(a, 0, a.length);

        for(int i=0;i<a.length;i++) {
            System.out.print(a[i]);
        }


        int[] temp = new int[5];
        int[] input = {1,2,3,4,5 };
        int j = 0;
        int k =0;
        while(j<input.length) {
            temp[j++] = input[k++];
        }
        System.out.println(j);
        System.out.println(k);
        for(int i=0;i<temp.length;i++) {
            System.out.print(temp[i]);
        }





    }

    // draw the recursion tree for better understanding
    // logical partition, we do not create any left and right array
    // as it is a logical array we cannot do a.length/2
    private static void split(int[] a, int s, int e) {

        // as we are
        if (e - s < 2) {
            return;
        }
        int m = (e + s) / 2;
        split(a, s, m);
        split(a, m, e);
        merge(a, s, m, e);
        // System.out.println("s "+s+"e "+e);


    }

    //remember right array is always sorted and copied to the main array

    // {5,3,8,1}
    // {8,1} at this point s = 2 and e = 4 and m = 3 (2+4/2)
    private static void merge(int[] a, int s, int m, int e) {

        int t = 0;
        int[] temp = new int[e-s];
        int lp = s;
        int rp = m;

        while(lp < m && rp < e) {  // 2 4
            temp[t++] = a[lp] < a[rp]? a[lp++] : a[rp++];
        }
        //copy the left over from left to temp array
        //copy from right is not needed as it is already sorted
        System.arraycopy(a, lp, a, s+t, m-lp);
        System.arraycopy(temp, 0, a, s, t);


    }

}
