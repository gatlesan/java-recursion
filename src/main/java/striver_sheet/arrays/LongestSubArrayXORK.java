package striver_sheet.arrays;

import java.util.*;

public class LongestSubArrayXORK {


    //subarray - contiguous part
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4,4,6,6,2,2);
        System.out.println(countSubArrays(list, 6));

        List<Integer> list1 = Arrays.asList(4,2,2,6,4,4);
        System.out.println(find2(list1,4));

        //List<Integer> list2 = Arrays.asList(4,2,2,6,4);
        List<Integer> list2 = Arrays.asList(5,6,7,8,9);
        System.out.println(findXOR(list2,5));

        //List<Integer> list3 = Arrays.asList(4,2,2,6,4);
        List<Integer> list3 = Arrays.asList(5,6,7,8,9);
        System.out.println(findXOR2(list3, 5));


    }

    //O(n^2)
    private static int countSubArrays(List<Integer> list, int k) {
        int xr = 0;
        int c =0;
        int max = 0;
        for(int i=0;i<list.size();i++) {
            xr = list.get(i);
            List<Integer> l = new ArrayList<>(list.get(i));
            for(int j=i+1;j<list.size();j++) {
                xr = xr ^ list.get(j);
                l.add(list.get(j));
                if(xr == 6) {
                    c++;
                    max = max > c ? max: c;
                    System.out.println(l);
                    xr = 0;
                    l.clear();
                }
            }

        }
        return max;
    }


    //find no of subarray with sum k
    //O(3N) for 5 elements 5+4+3... n*(n+1)/2 15
    //problem with this kind of for loop where i = 0 and j = i+1 is always takes two or more elements
    private static int find(List<Integer> list, int k) {
        int s = 0;
        int c = 0;
        for(int i=0;i<list.size();i++) {
            s = list.get(i);
            for(int j= i+1;j<list.size(); j++) {
                s+=list.get(j);
                if(s == k) {
                    c++;
                }
            }
        }
        return c;
    }

    //{4,2,2,6,4,4}
    //run for n times each starting from i were i =0 ... n-1
    private static int find2(List<Integer> list, int k) {
        int s = 0;
        int c = 0;
        //*** second for loop i = j
        for(int i=0;i<list.size();i++) {
            for(int j=i;j<list.size();j++) {
                s+=list.get(j);
                if(s == k) {
                    c++;
                }
            }
            s=0;
        }
        return c;
    }

    private static int findXOR(List<Integer> list, int k) {
        int c = 0;
        int xr = 0;
        for(int i=0;i<list.size();i++) {
            for(int j=i;j<list.size();j++) {
                xr = xr ^ list.get(j);
                if(xr == k) {
                    c++;
                }
            }
            xr = 0;
        }
        return c;
    }

    //formula: x = xr^k
    //1. find xr till current index
    //2. store xr in hash initially store (0,1)
    //3. find x = xr^k if hash contains x take count and add it
    private static int findXOR2(List<Integer> list, int k) {
        int xr = 0;
        int c = 0;
        Map<Integer, Integer> hash = new HashMap<>();
        hash.put(0,1);
        for(int i=0;i<list.size();i++) {
            xr = xr ^ list.get(i);
            if(hash.containsKey(xr)) {
                hash.put(xr, hash.get(xr) + 1);
            } else {
                hash.put(xr, 1);
            }
            int x = xr ^ k;
            if(hash.containsKey(x)) {
                c+=hash.get(x);
            }
        }
        return c;
    }
}



