package dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DistinctSubSets {

    public static void main(String[] args) {

        String s = "rabbbit";
        String t = "rabbit";
        List<Character> list = Stream.of(s.split("")).map(e -> e.charAt(0)).collect(Collectors.toList());
        List<Character> list1 = Stream.of(t.split("")).map(e -> e.charAt(0)).collect(Collectors.toList());
        List<List<Character>> colList = new ArrayList<>();
        getDistinctSubSetCount(0, new ArrayList<>(), colList, list);
        System.out.println(colList.stream().filter(st -> st.equals(list1)).collect(Collectors.toList()).size());


    }

    private static void getDistinctSubSetCount(int i, ArrayList<Character> ds, List<List<Character>> col, List<Character> list) {


        if(i == list.size()) {
            // need this as ds is in stack and will lose its value once exited
            col.add(new ArrayList<>(ds));
            System.out.println(ds);
            return;
        }

        ds.add(list.get(i));
        getDistinctSubSetCount(i+1, ds, col, list);
        ds.remove(ds.indexOf(list.get(i)));
        getDistinctSubSetCount(i+1, ds, col, list);
    }
}
