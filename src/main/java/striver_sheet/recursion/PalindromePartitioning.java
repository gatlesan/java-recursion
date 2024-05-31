package striver_sheet.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PalindromePartitioning {

    public static void main(String[] args) {

        String s = "aabb";
        List<List<String>> res = new ArrayList<>();


        pp(s, 0, new ArrayList<>(), res);
        System.out.println(res);

    }


    //*** Do not use stringbuilder reverse function for palindrome
    //*** 1. Intuition is to check the partition from 0 to 0, 0 to 1 and 1 to 2 ... for loop inside a recursion pattern
    //*** 2. if given string from i and j+1 forms a palindrome then add to ds and call
    //*** 3. very important recursion with j+1 not i+1 as you need next recursion to carry on with j+1 to s.length
    private static void pp(String s, int i, List<String> ds, List<List<String>> res) {

        if(i == s.length()) {
            res.add(new ArrayList<>(ds));
            return;
        }

        for(int j=i;j<s.length();j++) {
            if(isPalindrome(s, i, j)) {
                ds.add(s.substring(i, j + 1));
                pp(s, j+1, ds,res);
                ds.remove(ds.size()-1);
            }
        }
    }

    private static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        return  sb.equals(sb.reverse());
    }

    static boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }
}
