package striver_sheet.arrays;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {

        //Set ds - set.add will call the equals on the object with existing element
        //Objects.equals
        Integer obj1 = 12;
        Integer obj2 = 13;
        System.out.println(Objects.equals(obj1, obj2));


        //to avoid storing the same triplets in different order sort and add them to the set
        //sort is required because equals on the list relays on the order
        Set<Integer> set = new HashSet<>();
        set.addAll(Arrays.asList(-1, -1, 2));
        System.out.println(set);
        boolean res = Arrays.asList(-1, -1, 2).equals(Arrays.asList(-1, 2, -1));
        System.out.println(res);
        Set<List<Integer>> set1 = new HashSet<>();
        set1.add(Arrays.asList(-1, -1, 2));
        set1.add(Arrays.asList(-1, 2, -1));
        System.out.println(set1);

        List<Integer> a = Arrays.asList(1, 0, -1, 0, -2, 1, 1);
        System.out.println(findTrips(a, 0));
        // System.out.println(findTriplets(a,0));


        //optimal

        List<Integer> l = Arrays.asList(1, 0, -1, 0, -2, 1, 1);
        System.out.println(findTripsOptimal(l, 0));


        practise();
        practise1();
        practise2();
    }


    //BF-three for loops to find 3 triplets
    //Sort and add them to the Set
    //O(n^3)
    private static Set<List<Integer>> findTriplets(List<Integer> arr, int t) {

        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                for (int k = j + 1; k < arr.size(); k++) {
                    if (arr.get(i) + arr.get(j) + arr.get(k) == t) {
                        List<Integer> res = Arrays.asList(arr.get(i), arr.get(j), arr.get(k));
                        Collections.sort(res);
                        set.add(res);
                    }
                }
            }
        }
        return set;
    }

    //Using t3 = -(t1+t2);
    //Using hashing to store the element in between  --> i and j
    //Use contains to find t3
    private static Set<List<Integer>> findTrips(List<Integer> list, int t) {

        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            Set<Integer> tempSet = new HashSet<>();
            for (int j = i + 1; j < list.size(); j++) {
                int t3 = t - (list.get(i) + list.get(j));
                //hashset contains O(1)
                if (tempSet.contains(t3)) {
                    List<Integer> res = Arrays.asList(list.get(i), list.get(j), t3);
                    Collections.sort(res);
                    set.add(res);
                }
                tempSet.add(list.get(j));
            }
        }
        return set;

    }

    //Optimal: Perform initial sort and use three pointers i,j and k
    //TC: outer for loop O(n) and inner while near about n because it is always n-i times total: O(n^2)
    //SC: No extra space used
    private static List<List<Integer>> findTripsOptimal(List<Integer> list, int t) {
        List<List<Integer>> lists = new ArrayList<>();
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            int j = i + 1;
            int k = list.size() - 1;
            //*** remember
            if (i > 0 && list.get(i) == list.get(i - 1)) {
                continue;
            }
            while (j < k) {
                int t1 = list.get(i), t2 = list.get(j), t3 = list.get(k);
                if (t1 + t2 + t3 == t) {
                    lists.add(Arrays.asList(t1, t2, t3));
                    j++;
                    k--;
                    //*** without this res will have duplicate triplets remember j < k
                    while (j < k && list.get(j) == list.get(j - 1)) {
                        j++;
                    }
                    while (j < k && list.get(k) == list.get(k + 1)) {
                        k--;
                    }
                } else if (t1 + t2 + t3 > t) {
                    k--;
                } else if (t1 + t2 + t3 < t) {
                    j++;
                }
                //without this res will have duplicate triplets
                //Do this when have taken both j and k

            }
        }
        return lists;
    }


    //O(n^3)
    private static void practise() {
        List<Integer> list = Arrays.asList(-3, 0, 1, 2, -1, 1, -2);
        Set<List<Integer>> uniqueTrips = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                for (int k = j + 1; k < list.size(); k++) {
                    int t1 = list.get(i);
                    int t2 = list.get(j);
                    int t3 = list.get(k);
                    if (t1 + t2 + t3 == 0) {
                        List<Integer> res = Arrays.asList(t1, t2, t3);
                        Collections.sort(res);
                        uniqueTrips.add(res);
                    }
                }
            }
        }
        System.out.println(uniqueTrips);
    }

    //O(n^2)
    //t3 could be anything which is not a part of the list and also can take same element twice
    //we need some way to take only in between elements for possible t3
    //****** Need hashing to store in between elements
    private static void practise1() {
        int k = 0;
        List<Integer> list = Arrays.asList(-3, 0, 1, 2, -1, 1, -2);
        Set<List<Integer>> uniqueTrips = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            Set<Integer> inBetween = new HashSet<>();
            for (int j = i + 1; j < list.size(); j++) {
                int t1 = list.get(i);
                int t2 = list.get(j);
                int t3 = k - (t1 + t2);
                if (inBetween.contains(t3)) {
                    List<Integer> res = Arrays.asList(t1, t2, t3);
                    Collections.sort(res);
                    uniqueTrips.add(res);
                }
                inBetween.add(list.get(j));
            }
        }
        System.out.println(uniqueTrips);
    }

    private static void practise2() {
        int sum = 0;
        List<Integer> list = Arrays.asList(-3, 0, 1, 2, -1, 1, -2);
        Collections.sort(list);
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            int j = i+1;
            int k = list.size() - 1;
            while (j<k) {
                int t1 = list.get(i);
                int t2 = list.get(j);
                int t3 = list.get(k);
                if (t1 + t2 + t3 == 0) {
                    List<Integer> res = Arrays.asList(t1, t2, t3);
                    Collections.sort(res);
                    set.add(res);
                } else if (t1 + t2 + t3 > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
    }
}
