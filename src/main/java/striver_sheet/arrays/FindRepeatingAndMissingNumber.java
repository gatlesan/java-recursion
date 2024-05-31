package striver_sheet.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FindRepeatingAndMissingNumber {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(3,1,2,5,3);

        //Build a frequency array using array which will increment the counter @ given index of an element
        //this way if the counter is 2 --> that is the duplicate value and if counter is 0 other than at index
        //0 that is the missing value

        // time complexity is O(n) and space complexity is O(n)
        // size+1 because we also have 0 to fill with...
        int size = list.size() + 1;
        int[] freq = new int[size];


        for(int i=0;i<list.size();i++) {
            if(freq[list.get(i)] == 0) {
                freq[list.get(i)] = 1;
            } else if(freq[list.get(i)] > 0) {
                freq[list.get(i)] = freq[list.get(i)]+1;
            }
        }

        List<Integer> freqList = Arrays.stream(freq).boxed().collect(Collectors.toList());
        System.out.println(freqList);

        for(int i=1;i<freq.length;i++) {

            if(freq[i] == 0)
                System.out.println("missing element is "+i);
            else if(freq[i] > 1)
                System.out.println("Repeated element is "+i);
        }

        find();
    }


    // space complexity can be optimized using XOR
    // ZOR (^) operator even 1's --> 0 and odd 1's --> 1
    // 5 ^ 5 --> 0 same numbers are ZOR will give 0
    // 5 ^ 2 --> 7

    // 1. XOR list ^ natural numbers till N
    // 2. Find the differentiating bit, first one from the right  (xr & ~(xr - 1));
    // 3. Put them into two parts zero's and one's if diff $ number != 0 then one group or else zero group
    private static void find() {

        int xr = 0;
        List<Integer> list = Arrays.asList(4,3,6,2,1,1);

        // 1. find the xr of both the lists
        for(int i=0;i<list.size();i++) {
            xr = xr ^ list.get(i) ^ i+1;
        }

        //2. Find the diff bit
        int diff = (xr & ~(xr - 1));

        //3. Group the one's and zero's for list elements
        int zero = 0;
        int one = 0;

        // Given list
        for(int i=0;i<list.size();i++) {
            if((diff & list.get(i)) != 0) {
                one = one ^ list.get(i);
            } else {
                zero = zero ^ list.get(i);
            }
        }

        // Natural numbers
        for(int i=1;i<=list.size();i++) {
            if((diff & i) != 0) {
                one = one ^ i;
            } else {
                zero = zero ^ i;
            }
        }

        System.out.println(xr);
        System.out.println("one "+one + " zero "+zero);

        int c = 0;
        // we still do not know if one is duplicate and zero is missing
        for(int i=0;i<list.size();i++) {
            if(list.get(i) == one) {
                c++;
            }
        }

        if(c == 2) {
            System.out.println("Duplicate "+one);
            System.out.println("Missing "+zero);
        } else {
            System.out.println("Duplicate "+zero);
            System.out.println("Missing "+one);
        }
    }
}
