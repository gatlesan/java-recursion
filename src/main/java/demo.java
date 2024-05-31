import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class demo {
    public static void main(String[] args) {

//        List<List<Integer>> list = new ArrayList<>();
//        add(5, list, new ArrayList<Integer>());
//        System.out.println(list);

//        int[] a = {1,2,3};
//        List<Integer> ds = new ArrayList<>();
//        call(0, ds, a);
//
//        String s = "abcdef";
//        String t = "aca";
//
//
//        List<Character> list1 = Stream.of(s.split("")).map(s1 -> s1.charAt(0)).collect(Collectors.toList());
//        List<Character> list2 = Stream.of(t.split("")).map(s2 -> s2.charAt(0)).collect(Collectors.toList());
//        System.out.println(list1.equals(list2));
//
//
//        System.out.println(isCharSub(0, new ArrayList<>(), list1, list2));

//
//        int i = 1;
//        System.out.println(i++);
//        System.out.println(i+1);
//        int j = 1;
//        System.out.println(++j);


        float f = (float) 1/2;
        System.out.println(f);
        System.out.println(String.format("%.6f",f));


       // int[] a = {-1,1,-1};
        long pos = List.of(-1,2,2).stream().filter(e -> e > 1).count();
        float f1 = (float) pos/6;
        System.out.println(String.format("%.6f",f1));

        List<Integer> l = List.of(1,2,3,4,5);

        //int max = l.stream().filter(e -> l.indexOf(e) != 0 ).reduce(0, (e1, e2) -> e1 + e2);
        //int min = l.stream().filter(e -> l.indexOf(e) != l.size()-1).reduce(0, (e1, e2) -> e1 + e2);
        //System.out.print(max + " " + min);

        List<Long> ll = Arrays.asList(623958417L,467905213L,714532089L,938071625L);
        System.out.println(ll.stream().reduce(0L, (a,b) -> a+b));
        ll.sort((e1,e2) -> e1.compareTo(e2));
//        System.out.println(ll);
//        long min1 = ll.stream().filter(e -> ll.indexOf(e) != ll.size()-1).reduce(0, (a,b) -> a+b);
//        ll.stream().filter(e -> {
//            System.out.println(ll.indexOf(e));
//            return ll.indexOf(e) != 0;}).forEach(System.out::println);
//        // System.out.println(min1 + " " + max1);
//
//        int max1 = Integer.MIN_VALUE;
//        for(int i : ll) {
//            if(ll.indexOf(i) != 0)
//            max1 = max1 + i;
//        }
//
//        System.out.println(Integer.valueOf(max1) + " " + min1);

        List<Long> arr = Arrays.asList(5L,5L,5L,5L,5L);
        long min1 = arr.stream().filter(e -> arr.indexOf(e) != arr.size()-1).reduce(0L, (a,b) -> a+b);
        long max1 = arr.stream().filter(e -> arr.indexOf(e) != 0).reduce(0L, (a,b) -> a+b);
        arr.sort((e1,e2) -> e1.compareTo(e2));
        System.out.println(min1 + " " + max1);

        List<Integer> a = Arrays.asList(1,2,3,4,3,4,1);
        a.sort((e1,e2) -> e1.compareTo(e2));
        System.out.println(a);
        for(int i = 0; i < a.size()-1 ;) {

            int nextIndex = i+1;
            if(nextIndex < a.size() && a.get(i) != a.get(i+1)) {
                System.out.println(a.get(i));
            }

            i =i +2;
        }

        List<Integer> in = Arrays.asList(0,2,1,2);
        int[] lis = new int[in.size()+1];
        System.out.println(lis.length);

        for(int i : in) {
            lis[i] = lis[i] + 1;
        }

        for(int i : lis) {
            System.out.print(i);
        }


        System.out.println(" ");

        List<Integer> listResult = Arrays.stream(lis).boxed().collect(Collectors.toList());

        int[] res = listResult.stream()
                .mapToInt(i -> i)
                .toArray();

        System.out.println(res);

        List<List<Integer>> list2 = Arrays.asList(Arrays.asList(1,2,3),Arrays.asList(4,5,6),Arrays.asList(8,9,10,1),Arrays.asList(8,9,10,1));System.out.println(list2.size());

        int maxV = Integer.MIN_VALUE;
        for(int i=0; i < list2.size()/2; i++) {
            for(int j=0; j < (list2.get(0).size())/2; j++) {
                maxV = maxV > list2.get(i).get(j) ? maxV : list2.get(i).get(j);
            }
        }
        System.out.println(maxV);











    }

    private static boolean isCharSub(int i, List<Character> ds, List<Character> list, List<Character> toMatch) {

        if(i == list.size()) {
            if(ds.equals(toMatch)) {
                System.out.println(ds);
                return true;
            }
            return false;
        }

        ds.add(list.get(i));
        if(isCharSub(i + 1, ds, list, toMatch))
            return true;
        ds.remove(ds.indexOf(list.get(i)));
        if(isCharSub(i + 1, ds, list, toMatch))
            return true;

        return false;
    }

    private static void call(int i, List<Integer> ds, int[] a) {

        if(i == a.length) {
            System.out.println(ds);
            return;
        }

        ds.add(a[i]);
        call(i+1,ds,a);
        ds.remove(ds.indexOf(a[i]));
        call(i+1,ds,a);

    }

    

    private static void add(int n, List<List<Integer>> ds, List<Integer> l) {

        if(n < 1) {
            return;
        }
        l.add(n);
        if(n == 1) {

            ds.add(l);
        }
        add(n-1, ds, l);

    }
}
