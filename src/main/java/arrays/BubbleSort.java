package arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] a = { 5,3,8,1 };

        //Un partition index initially all are not sorted
        //in place
        //O(n^2)
        //Quadratic time complexity
        //stable vs unstable - order of duplicate elements
        //unstable - order of duplicate elements is not maintained
        //stable sort algorithm - order of duplicate elements is maintained
        //Bubble sort - stable sort algorithm

        //Bubble sort swapping the adjacent elements if they are in wrong order
        //bubble the largest element to the end of the array

        //Selection sort we select the largest element and swap it with the last element

      /*  int i = a.length;
        while(i >= 0) {
            for(int j=0; (j+1)<i; j++) {
                //stable sort algorithm - without '>='
                if(a[j] > a[j+1]) {
                    swap(j ,j+1, a);
                }
            }
            i--;
        }
        print(a);*/

         // left portion ---> till k-1, k-2... 0
        // Selection sort scan for the largest element and swap it with the last element
        // unstable sort algorithm
    /*    int k =a.length;
        while(k>=0) {
            int larindex = k-1;
            for(int l=0;l<k;l++) {
                if(a[l] > a[larindex]) {
                    swap(l, larindex, a);
                }
            }
            k--;
        }
        print(a);*/


        //Insertion sort - select first element and insert it in the sorted array
        //stable sort algorithm

       /* for(int m=0;m<a.length;m++) {
            for(int n=m+1;n<a.length;n++) {
                if(a[n] < a[m]) {
                    swap(n,m,a);
                }
            }
        }
        print(a);*/


        //shell sort -variation of insertion sort
        //preliminary sort algorithm
        //Gap value is important
        //calculate the gap using knuth sequence
        // (3^k-1)/2 - k is based on length of the array
        // 1,4,13,40,121
        //select the gap closer to length of the array but not > a.length
        //difficult to nail down the complexity as it depends on the gap
        //Unstable

        // preliminary
        // still insertion sort is needed after this...
        int gap = a.length/2;
        for(int p=0;p<a.length && gap>0;p++) {
            for(int g=gap;g<a.length;) {
                if(a[p] > a[g]) {
                    swap(p,g,a);
                }
                g = g+gap;
            }
            gap = gap/2;
        }

        for(int m=0;m<a.length;m++) {
            for(int n=m+1;n<a.length;n++) {
                if(a[n] < a[m]) {
                    swap(n,m,a);
                }
            }
        }

        print(a);




    }

    private static void swap(int i, int j, int[] a) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void print(int[]  a) {
        for(int i=0; i<a.length; i++) {
            System.out.print(a[i]);
        }
    }
}
