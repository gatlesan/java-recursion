package striver_sheet.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LargestSubArrayKSum {
    public static void main(String[] args) {

        //** Two pointer
        //BF: one fixed pointer and j -> i+1 ... n-1
        //O(n^2)


        List<Integer> l = Arrays.asList(1,-1,3,2,-2,-8,1,7,10,23);
        System.out.println(findLen(l));
    }


    //O(n)
    //*** PreSum and Hashing
    //Algo: if sum of elements from 0 to 6 out 10 elements is total sum then elements from 7...9 should be 0

    //1. put first element in hashmap with index (e,i)
    //2. add next e and store sum if it does not exists, do not do it for sum = 0
    //3. If sum at given index --> hashmap has a val then currIndex - hashIndex will give the max len
    //{1,-1,3,2,-2,-8,1,7,10,23}
    private static int findLen(List<Integer> arr) {
        int maxLen = 0;
        Map<Integer, Integer> hash = new HashMap<>();
        int i = 0;
        int s = 0;
        while (i < arr.size()) {
            s += arr.get(i);
            //** edge case remember this...
            if(s == 0){
                maxLen = i+1;
            }
            else if (s != 0 && hash.get(s) == null) {
                hash.put(s, i);
            } else if (hash.get(s) != null) {
                int diff = i - hash.get(s);
                maxLen = maxLen > diff ? maxLen : diff;
            }
            i++;
        }
        return maxLen;
    }
}
