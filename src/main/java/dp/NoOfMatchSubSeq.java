package dp;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NoOfMatchSubSeq {

    public static void main(String[] args) {

        String[] s = {"a", "ab", "ce"};
        List<String> list = Stream.of(s).collect(Collectors.toList());
        System.out.println(list.contains("aa"));

    }
}
