package patterns.matrix;

import java.util.HashSet;
import java.util.Set;

public class DistinctIsland2 {

    public static void main(String[] args) {

        int[][] island = {
                { 1, 1, 0, 1 },
                { 0, 1, 1, 0 },
                { 0, 0, 0, 0 },
                { 1, 1, 0, 0 },
                { 0, 1, 1, 0 }
        };

        Set<String> distinctIslands = new HashSet<>();
        for(int i=0;i<island.length;i++) {
            for(int j=0;j<island[0].length;j++) {
                if(island[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    StringBuilder path = traverse(i,j,island,sb,"O");
                    if(path!=null) {
                        distinctIslands.add(path.toString());
                    }
                }
            }
        }
        System.out.println(distinctIslands);
    }

    private static StringBuilder traverse(int i, int j, int[][] island, StringBuilder sb, String path) {

        if(i < 0 || j <0 || i>island.length-1 || j>island[0].length-1 || island[i][j] == 0) {
            return null;
        }

        island[i][j] = 0;
        sb.append(path);
        traverse(i+1, j, island, sb, "D");
        traverse(i-1, j, island, sb, "U");
        traverse(i, j+1, island, sb, "R");
        traverse(i, j-1, island, sb, "L");
        return sb;
    }
}
