package matrix;

public class MatrixTraversal {

    public static void main(String[] args) {

        int m = 3;
        int n = 3;

        int mid = (m*n)/2;
        System.out.println(mid);

        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        for(int i=0;i<mat.length;i++) {
            for(int j=0;j<mat[i].length;j++) {
                System.out.println(mat[i][j]);
            }
        }

        int intersectionVal = 0;
        int counter = 0;
        if((m*n) % 2 != 0) {
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[i].length; j++) {
                    if (counter == mid) {
                        intersectionVal = mat[i][j];
                    }
                    counter++;
                }
            }
        }

        System.out.println(intersectionVal);


        //diagonal traversal - top left to bottom right
        int sum = 0;
        for(int i =0,j=0; i<mat.length && j<mat[i].length; i++,j++) {
            sum += mat[i][j];
        }

        System.out.println(sum);

        //diagonal traversal - bottom left to top right
        int revSum = 0;
        for(int i= mat.length-1, j=mat[i].length-1; i > -1 && j > -1; i--,j--) {
            revSum += mat[i][j];
        }

        System.out.println(revSum);

        System.out.println("total sum "+((sum+revSum)-intersectionVal));
    }
}
