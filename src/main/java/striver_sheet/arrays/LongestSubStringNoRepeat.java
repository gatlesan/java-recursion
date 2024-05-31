package striver_sheet.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LongestSubStringNoRepeat {

    public static void main(String[] args) {

        System.out.println(longest("abcabcbbefghij"));
        System.out.println(longest("abecaabcdba"));
        System.out.println(longest("bbbbb"));
    }

    private static int longest(String s) {
        List<Character> tempList = new ArrayList<>();
        StringBuilder res =  new StringBuilder();
        for(int i=1;i<s.length();i++) {
            if(!tempList.contains(s.charAt(i))) {
                res.append(s.charAt(i));
                tempList.add(s.charAt(i));
            }
        }
        System.out.println(res);
        return res.length();
    }
}
