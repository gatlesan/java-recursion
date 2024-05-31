package patterns.matrix;

import java.util.HashSet;
import java.util.Set;

public class DistinctIsland {

    public static void main(String[] args) {

/*        int[][] island = {
                {1, 1, 0, 1, 1},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {0, 1, 1, 0, 1},
                {0, 1, 1, 0, 1}
        };*/

        int[][] island = {
                { 1, 1, 0, 1 },
                { 0, 1, 1, 0 },
                { 0, 0, 0, 0 },
                { 1, 1, 0, 0 },
                { 0, 1, 1, 0 }
        };

        Set<String> distinctIslands = new HashSet<>();
        for (int i = 0; i < island.length; i++) {
            for (int j = 0; j < island[0].length; j++) {
                if (island[i][j] == 1) {
                    distinctIslands.add(findIslandPath(island, i, j, "O"));
                }
            }
        }

        System.out.println(distinctIslands);
    }


    private static String findIslandPath(int[][] mat, int i, int j, String path) {
        if (i < 0 || i > mat.length - 1 || j < 0 || j > mat[0].length - 1 || mat[i][j] == 0) {
            return "";
        }

        //mark visited
        mat[i][j] = 0;

        return path + findIslandPath(mat, i + 1, j, "D") +
                findIslandPath(mat, i - 1, j, "U") +
                findIslandPath(mat, i, j + 1, "R") +
                findIslandPath(mat, i, j - 1, "L");

    }
}
