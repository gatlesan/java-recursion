package striver_sheet.arrays;

public class MatrixZeros {

    public static void main(String[] args) {

        // Minimum time required to traverse a 2D array is O(n*m) can't optimize further in time.
        // 1. traverse the matrix, mark row and column to -1 for when ever we find 0.
        // 2. traverse the matrix again and check if the row and column is marked to -1.
        // 3. if it is -1, then mark the value to 0.
        // 2 * O(n*m) + O(n+m)



    }
}
