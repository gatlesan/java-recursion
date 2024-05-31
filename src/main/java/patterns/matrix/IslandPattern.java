package patterns.matrix;

import java.util.LinkedList;
import java.util.Queue;

public class IslandPattern {


    public static void main(String[] args) {

        //non recursion
        Queue<int[]> bfsQueue = new LinkedList<>();
        bfsQueue.offer(new int[]{1, 2});
        bfsQueue.offer(new int[]{3, 4});
        System.out.println(bfsQueue.peek()[0]);
        System.out.println(bfsQueue.peek()[1]);


        BiggestIsland bi = new BiggestIsland();
        int[][] mat = {{1, 1, 1, 0, 0}, {0, 1, 0, 0, 1}, {0, 0, 1, 1, 0}, {0, 1, 1, 0, 0}, {0, 0, 1, 0, 0}};
        System.out.println(bi.findBiggestIsland(mat));
    }
}


class BiggestIsland {

    public static int findBiggestIsland(int[][] mat) {

        int maxLand = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    {
                        int res= dfsTraversal(mat, i, j);
                        System.out.println(res);
                        maxLand = Math.max(maxLand, res);
                    }
                }
            }
        }
        return maxLand;
    }

    private static int dfsTraversal(int[][] mat, int i, int j) {

        if (i < 0 || i >= mat.length || j < 0 || j >= mat[0].length || mat[i][j] == 0) {
            return 0;
        }

        mat[i][j] = 0;

        return 1 + dfsTraversal(mat, i + 1, j) + dfsTraversal(mat, i - 1, j) + dfsTraversal(mat, i, j + 1) + dfsTraversal(mat, i, j - 1);

    }
}
