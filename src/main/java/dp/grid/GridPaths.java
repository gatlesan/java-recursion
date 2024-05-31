package dp.grid;

public class GridPaths {


    public static void main(String[] args) {
        int[][] a = {{1,2,3},{4,5,6}};

        System.out.println(allWays(2,2,a));
    }

    private static int allWays(int i, int j, int[][] a) {

        if(i < 0 || j < 0) {
            return 0;
        }
        if(i == 0 && j == 0) {
            return 1;
        }
        int l = allWays(i-1, j,a);
        int r = allWays(i,j-1,a);
        return l+r;
    }

}
