package matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MatrixDemo {

    public static void main(String[] args) {

        List<List<Integer>> mat = Arrays.asList(Arrays.asList(1,2,3),Arrays.asList(4,5,6),Arrays.asList(7,8,9));
        int n = mat.size();
        int m = mat.get(0).size();
        System.out.println("nxm "+n+"x"+m);

        //convert List<List> to matrix
        int[][] matrix = new int[n][m];
        for(int i=0;i<n;i++){
            matrix[i] = mat.get(i).stream().mapToInt(e -> e).toArray();
        }

        //print the matrix
        print(matrix);

        //transpose
        //diagonals will not change
        for(int i=0;i<n;i++){
            for(int j=i+1;j<m;j++){
                swapList(i,j,j,i,mat);
            }
        }

        //After transpose print the matrix
        System.out.println();
        print(matrix);

        List<List<Integer>> res = new ArrayList<>(n);

        //reverse
        for(int i=0;i<n;i++) {
            List<Integer> l = mat.get(i);
            Collections.reverse(l);
            res.add(i, l);
        }

        System.out.println(res);

    }

    private static void swap(int i, int j, int k, int l,int[][] mat) {
        int temp = mat[i][j];
        mat[i][j] = mat[k][l];
        mat[k][l] = temp;
    }

    private static void swapList(int i, int j, int k, int l,List<List<Integer>> list) {
        List<Integer> r1 = list.get(i);
        List<Integer> r2 = list.get(k);

        int temp = r1.get(j);
        r1.set(j,r2.get(l));
        r2.set(l, temp);

    }

    private static void print(int[][] matrix) {
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
