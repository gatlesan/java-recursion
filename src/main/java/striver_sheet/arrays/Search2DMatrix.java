package striver_sheet.arrays;

import java.util.Arrays;
import java.util.List;

public class Search2DMatrix {

    public static void main(String[] args) {




        // O(NxM) if visited every element in the matrix
        // O(N) + log(M) if find a row where a[i][0] >= t && t <= a[i][M-1] and do Binary Search in the row to find the element
        // O(log(NxM)) if performed BS on the imaginary 1D array we do not convert the 2D to 1D but work on imaginary array
        // formula for a given index in an array find the co-ordinates in 2D
        // (i/c)/(i%c) = (5/4)/(5%4) = 1/1 (1,1)


        // *** Binary Search - no recursion is needed just while loop...
        // *** Iterate the loop till s>e as you do m+1 and m-1 for the s and e at a point s > m and no t is found...

        List<Integer> list = Arrays.asList(1,2,3,5,6,7,8,9,10);
        int s = 0; int e = list.size()-1; int t = 4;
        while(s<=e) {
            int m = (s+e)/2;
            if(list.get(m) == t) {
                System.out.println("Target " + t + " found!");
                return;
            }
            else if(t < list.get(m)) {
                e = m-1;
            }
            else if(t > list.get(m)) {
                s = m+1;
            }
        }
        System.out.println("Target not found!");

        System.out.println(search2DMatrix(30));









    }

    //*** Important formula is index/colLength and index%colLength
    //O(N)
    private static boolean search2DMatrix(int target) {
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int collen = arr[0].length;
        int start = 0;
        int end = (arr.length * arr[0].length) - 1;
        System.out.println(start +" "+end);
        while(start<=end) {
            int i = (start+end)/2;
            int r = i/collen;
            int c = i%collen;
            if(arr[r][c] == target) {
                return true;
            } else if(target > arr[r][c]) {
                start = i+1;
            } else if(target < arr[r][c]) {
                end = i-1;
            }
        }
        return false;
    }
}
