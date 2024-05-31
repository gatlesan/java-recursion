package matrix;

import java.util.Arrays;
import java.util.List;

public class FlipMatrix {

    public static void main(String[] args) {

        List<List<Integer>> matrix = Arrays.asList(Arrays.asList(112,42,83,119), Arrays.asList(56,125,56,49), Arrays.asList(15,78,101,43), Arrays.asList(62,98,114,108));

        int n = matrix.size();
        int sum = 0;
        for(int i=0; i<n/2; i++) {
            for(int j=0; j<n/2; j++) {
                sum+=Math.max(Math.max(matrix.get(i).get(j), matrix.get(i).get(n-j-1)),Math.max(matrix.get(n-i-1).get(j), matrix.get(n-i-1).get(n-j-1)));
            }
        }
        System.out.println(sum);
    }
}
