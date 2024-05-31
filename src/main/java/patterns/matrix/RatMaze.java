package patterns.matrix;

public class RatMaze {

    public static void main(String[] args) {
        int[][] maze = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}};

        int ways = findWays(0,0,maze,new boolean[maze.length][maze[0].length]);
        System.out.println(ways);
    }

    private static int findWays(int i, int j, int[][] maze, boolean[][] visited) {


        if(i < 0 || j < 0 || i >= maze.length || j >= maze[0].length || maze[i][j] == 0 || visited[i][j]) {
            return 0;
        }


        if(i == maze.length-1 && j == maze[0].length-1) {
            return 1;
        }

        visited[i][j] = true;
        int res = findWays(i-1, j, maze, visited) +
                findWays(i+1, j, maze, visited) +
                findWays(i, j-1, maze, visited) +
                findWays(i, j+1, maze, visited);

        //backtracking
        visited[i][j] = false;
        return res;
    }
}
