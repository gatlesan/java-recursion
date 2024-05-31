package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QuickSortPart1 {
    public static void main(String[] args) {

        List<Integer> arr = Arrays.asList(4,5,3,7,2);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();

        int p = arr.get(0);
        equal.add(p);
        for(int i=1;i<arr.size();i++) {
            int c =arr.get(i);
            if(c < p) {
                left.add(c);
            } else if(c > p) {
                right.add(c);
            }
        }
        System.out.println(left);
        System.out.println(right);
        System.out.println(equal);

    }
}
