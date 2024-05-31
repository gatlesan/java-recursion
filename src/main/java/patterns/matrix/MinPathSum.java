package patterns.matrix;

public class MinPathSum {


    public static void main(String[] args) {


        int[][] grid = {
                {5, 9, 6},
                {11, 5, 2},
                {0, 1, 3}
        };

        int[][] memo = new int[grid.length][grid[0].length];

        System.out.println(minPathSum(0,0,grid, 0, memo));
    }

    private static int minPathSum(int i, int j, int[][] grid, int pathSum, int[][] memo) {

        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return Integer.MAX_VALUE;
        }

        if(i == grid.length - 1 && j == grid[0].length - 1) {
            memo[i][j] = pathSum + grid[i][j];
            return memo[i][j];
        }

        //assumption that min sum will always be positive value
        if(memo[i][j] > 0) {
            return memo[i][j];
        }

        return Math.min(minPathSum(i, j+1, grid, grid[i][j]+pathSum, memo), minPathSum(i+1, j, grid, grid[i][j]+pathSum, memo));
    }
}
