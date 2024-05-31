package dp.strings;

public class LongestCommonSubSeq {

    // There could be two problems based on consecutive and non consecutive
    // power set or recursion
    // if non contigious it is straight forward to just look for the common chars in the string and count them
    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "bcaf";
        System.out.println(LongestCommonSubSeq(s1.length()-1, s2.length()-1, s1, s2));
    }

    private static int LongestCommonSubSeq(int i1, int i2, String s1, String s2) {

        if(i1 < 0 || i2 < 0) {
            return 0;
        }
        if (s1.charAt(i1) == s2.charAt(i2)) {
            return 1 + LongestCommonSubSeq(i1 - 1, i2 - 1, s1, s2);
        } else {
            int l = LongestCommonSubSeq(i1, i2 - 1, s1, s2);
            int r = LongestCommonSubSeq(i1 - 1, i2, s1, s2);
            return Math.max(l, r);
        }

    }
}


