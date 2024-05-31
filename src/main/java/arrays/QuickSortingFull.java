package arrays;

import java.util.*;

public class QuickSortingFull {

    public static void main(String[] args) {


        List<List<String>> a = Arrays.asList(Arrays.asList("0", "a"), Arrays.asList("1", "b"),Arrays.asList("0", "c"),Arrays.asList("1", "d"));


        Map<Integer, List<String>> map = new HashMap<>();
        for (int i = 0; i < a.size(); i++) {
            List<String> stringList = a.get(i);
            int index = Integer.valueOf(stringList.get(0));
            if (map.get(index) == null) {
                List<String> sList = new ArrayList<>();
                sList.add(stringList.get(1));
                map.put(index, sList);
            }
            else
                map.get(index).add(stringList.get(1));
        }

        StringBuilder res = new StringBuilder();
        for(int i=0;i<map.size();i++) {
            List<String> strings = map.get(i);
            int l = strings.size();
            if(l>0) {
                int h = l / 2;
                for (int j = 0; j < strings.size(); j++) {
                    if (j < h) {
                        res.append("-");
                    } else {
                        res.append(strings.get(j));
                    }
                }
            }
        }
        System.out.println(res);

        System.out.println(map);
    }
}
