package dp.strings;

import java.util.ArrayList;
import java.util.List;

public class PrintLongestSubSequence {
    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "bcaf";
        List<Character> res = new ArrayList();
        print(s1.length()-1, s2.length()-1, s1, s2, res);
        System.out.println(res);
    }
    private static int print(int i1, int i2, String s1, String s2, List<Character> res) {

        if(i1 < 0 || i2 < 0) {
            return 0;
        }
        if (s1.charAt(i1) == s2.charAt(i2)) {
            res.add(s1.charAt(i1));
            return 1 + print(i1 - 1, i2 - 1, s1, s2, res);
        } else {
            int l = print(i1, i2 - 1, s1, s2, res);
            int r = print(i1 - 1, i2, s1, s2, res);
            return Math.max(l, r);
        }
    }
}
