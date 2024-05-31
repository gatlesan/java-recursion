import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class StringChallenge {
    public static void main(String[] args) {

        List<String> grid = Arrays.asList("kc", "iu");
        System.out.println(gridChallenge(grid));

    }

    public static String gridChallenge(List<String> grid) {
        // Write your code here
        for (int j=0; j<grid.size(); j++) {
            for (int i = 0; i < grid.get(j).length() - 1; i++) {
                char[] c = grid.get(j).toCharArray();
                Arrays.sort(c);
                grid.set(j, new String(c));
            }
        }

        System.out.println(grid);

        for (int i = 0; i < grid.get(0).length(); i++) {
            int prev = 0;
            for (String s : grid) {
                int c = s.codePointAt(i);
                if (c < prev) {
                    return "NO";
                }
                prev = c;
            }
        }

        return "YES";
    }
}
