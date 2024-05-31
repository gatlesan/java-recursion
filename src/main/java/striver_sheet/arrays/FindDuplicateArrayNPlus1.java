package striver_sheet.arrays;

import java.util.*;

public class FindDuplicateArrayNPlus1 {

    // Important - Q' says n+1 size where each element is between 1  and n
    // 5+1 ---> {1,2,2,3,4,5}
    public static void main(String[] args) {

        // 1. BF --> sort and compare i with i+1 nlog(n) + O(n)
        // 2. Using frequency array O(n) and O(n) --> map can also be used
        // 3. LinkedList cycle method --> slow and fast pointers, if collides then it's a circle reset f and increment
        // each pointer by 1 if they meet again that's the duplicate...




        List<Integer> list1 = Arrays.asList(1,3,4,2,2);
        List<Integer> list = Arrays.asList(3,1,3,4,2);
        System.out.println(findDup(list));

        find();

    }

    private static int findDup(List<Integer> list) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            if (freq.get(list.get(i)) == null) {
                freq.put(list.get(i), i);
            } else {
                return list.get(i);
            }
        }
        return 0;
    }



    // O(n)
    /*Initially both slow and fast pointers start at the same element.
    The fast pointer moves 2 steps each time, while slow moves 1 step.
    Eventually fast will lap slow and they will collide at some node.
    After collision, we reset fast to the start.
    Now both move at the same pace, 1 step at a time.
    Where they collide again is the start of the cycle - which is the duplicate element.
    This works because before collision, fast covers 2x the distance as slow. So when they collide, fast is at the start of the cycle.
    Resetting fast to the start, and moving at same pace, leads to the cycle start.
    Let me know if this helps explain why the duplicate is found after the second collision!*/
    private static void find() {

        List<Integer> list = Arrays.asList(2,5,9,6,9,3,8,9,7,1);
        int s = list.size();
        // *** Important always point slow and fast to val @ 0 index...
        int slow = list.get(0);
        int fast = list.get(0);



        while(true) {
            slow = list.get(slow);
            fast = list.get(list.get(fast));
            if(slow == fast) {
                System.out.println("collide @ "+slow);
                break;
            }
        }

        //once they collide
        //reset fast to initial value
        fast = list.get(0);
        while(true) {
            slow = list.get(slow);
            fast = list.get(fast);
            if(slow == fast) {
                System.out.println("Duplicate is "+slow);
                break;
            }
        }

    }
}
