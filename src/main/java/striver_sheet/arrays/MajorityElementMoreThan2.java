package striver_sheet.arrays;

import java.util.Arrays;
import java.util.List;

public class MajorityElementMoreThan2 {

    public static void main(String[] args) {


        //List<Integer> l = Arrays.asList(3,2,3,3,3);
        List<Integer> l = Arrays.asList(2, 2, 1, 1, 1, 2, 2);
        //Find the majority element that occurs more than l.size()/2 times
        //that is 3/2 more than 1 time
        //O(n^2) two for loops with counter
        //O(n) using a hashmap with O(n)+O(1) for insertion and getting but space O(n)
        //Optimal: *****Moore's voting algorithm

        //1. Apply the moore's algo --> get the count and element
        //2. Iterate the array to find if the element occurred > l.size()/2

        int c = 0;
        int e = -1; //assuming all the elements are > 0
        for (int i = 0; i < l.size(); i++) {
            if (c == 0) {
                e = l.get(i);
            }
            if (l.get(i) == e) {
                c++;
            } else {
                c--;
            }
        }
        System.out.println(e + " " + c);
        // c > 5/2 = c > 2
        // find out how many times c has occurred
        int finalCount = 0;
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i) == e) {
                finalCount++;
            }
        }
        System.out.println("finalCount " + finalCount);
        if (finalCount > (l.size()) / 2)
            System.out.println("Res " + e);


        //**** Find all the elements which are > N/3
        // ** catch there will always be only <= two such elements
        // if N = 9, 9/3 = 3 and 4+4+(4) 3rd 4 is not possible because 12 > 9
        // ** Therefore, we just to find 2 such elements
        // ** Looks code checked the code

        //List<Integer> list = Arrays.asList(1,1,1,3,3,2,2,2);
        //List<Integer> list = Arrays.asList(1,2,2,3,2);
        List<Integer> list = Arrays.asList(11,33,33,11,33,11);

        Integer e1 = null;
        Integer e2 = null;
        int c1 = 0;
        int c2 = 0;

        for(int i=0;i<list.size();i++) {
            //** this && condition is important to avoid taking same elements in e1 and e2
            if(c1 == 0 && list.get(i) != e2) {
                e1 = list.get(i);
            } else if(c2 == 0 && list.get(i) != e1) {
                e2 = list.get(i);
            }
            if(list.get(i) == e1) {
                c1++;
            } else if(list.get(i) == e2) {
                c2++;
            } else {
                c1--;
                c2--;
            }
            System.out.println(e1+" "+c1);
            System.out.println(e2+" "+c2);
        }



    }
}
