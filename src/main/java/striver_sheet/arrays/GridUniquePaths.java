package striver_sheet.arrays;

import java.util.Arrays;
import java.util.List;

public class GridUniquePaths {

    public static void main(String[] args) {


        List<List<Integer>> list = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4), Arrays.asList(3, 4));
        //System.out.println(findUniquePaths(0, 0, list));

        int n = list.size();
        int m = list.get(0).size();
        int[][] memo = new int[n][m];
        //System.out.println(findUniquePaths(0, 0, list));
        System.out.println(findPathsMemo(0, 0, list, memo));
        System.out.println(findPathsOptimised(list));


    }

    //*** Brute force is using recursion... O(2^n) exponential
    //*** Use memoization reduce it to quadratic O(n^2)
    // find the changing states in recursion i and j i can go till n and j can go till m
    // declare the grid of nxm and store the computed values to avoid find sol for overlapping sub problems

    private static int findUniquePaths(int i, int j, List<List<Integer>> grid) {
        if (i == grid.size() - 1 && j == grid.get(0).size() - 1) {
            return 1;
        } else if (i > grid.size() - 1 || j > grid.get(0).size() - 1) {
            return 0;
        }
        return findUniquePaths(i, j + 1, grid) + findUniquePaths(i + 1, j, grid);
    }

    private static int findPathsMemo(int i, int j, List<List<Integer>> grid, int[][] memo) {
        if (i == grid.size() - 1 && j == grid.get(0).size() - 1) {
            return 1;
        } else if (i > grid.size() - 1 || j > grid.get(0).size() - 1) {
            return 0;
        }
        if(memo[i][j] != 0)
            return memo[i][j];
        else {
            memo[i][j] =  findUniquePaths(i, j + 1, grid) + findUniquePaths(i + 1, j, grid);
            return memo[i][j];
        }
    }

    //** Google--> still optimize using combinations ncr
    // the number of right directions is always m-1
    // the number of down directions is always n-1
    // total directions (m-1) + (n-1) (m+n)-2 5-2 = 3
    // Now selection/combination of R or B for 3 cols 3c2 or 3c1
    // ncr --> for loop for column
    private static int findPathsOptimised(List<List<Integer>> grid) {
        int m = grid.get(0).size();
        int n = grid.size();
        int t = (m+n)-2;
        int r = m-1;
        int res = 1;
        //find tcr
        for(int i=1;i<=r;i++) {
            res*= (t-r+1)/i;
        }
        return res;
    }
}
