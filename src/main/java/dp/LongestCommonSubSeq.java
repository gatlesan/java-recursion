package dp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LongestCommonSubSeq {

    public static void main(String[] args) {

        String s1 = "abcdef";
        String s2 = "ghi";
        List<Character> list1 = Stream.of(s1.split("")).map(e -> e.charAt(0)).collect(Collectors.toList());
        List<Character> list2 = Stream.of(s2.split("")).map(e -> e.charAt(0)).collect(Collectors.toList());
        System.out.println(getLongestComSubSeq(0, new ArrayList<>(), list1, list2, 0));

        System.out.println(list1.stream().map(c -> c.toString()).collect(Collectors.joining()));


    }

    private static int getLongestComSubSeq(int i, ArrayList<Character> ds, List<Character> list1, List<Character> list2, int longest) {

        if(i == list1.size()) {
            if(ds.equals(list2)) {
                longest = list2.size() > longest ? list2.size() : longest;
                return longest;
            }
            return longest;
        }

        ds.add(list1.get(i));
        longest = getLongestComSubSeq(i+1, ds, list1, list2, longest);
        ds.remove(ds.indexOf(list1.get(i)));
        longest = getLongestComSubSeq(i+1, ds, list1, list2, longest);

        return longest;

    }


}
