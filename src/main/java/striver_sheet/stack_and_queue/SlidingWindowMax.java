package striver_sheet.stack_and_queue;

import java.util.*;

public class SlidingWindowMax {


    // BF: O(n^2) for every i find sum of next k elements and finally return the max sum...
    // Understand Deque

    public static void main(String[] args) {

        // offer() to push the element to tail and push() to push at head
        // peek() and peekFirst() are same to peek at head
        // peekLast() to peek at tail
        // poolFirst to insert element at head
        // poolLast to insert element at tail
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());

        deque.addFirst(10);

        System.out.println(deque.peekFirst());

        deque.removeLast();

        System.out.println(deque.peekLast());


        System.out.println(findSlidingWindowMax(Arrays.asList(4,0,-1,3,5,3,6,8), 3));

    }

    // *** Intuition is to use deque to access front and rear elements - as this needs to be achieved in one pass
    // *** Maintain the decreasing order in deque - so that when looked at first element from rear/back you will always see the max q.peekLast() is the max
    // *** Always add index to the queue not values... *** Important
    // *** 1. for i >= k we do not need elements index at 0 when i @ 3 as k=3 we need elements from 1,2,3 so remove index 0 from the queue (removing out of bound indexes)
    // *** 2. if a[i] > peekFront remove - as we have to maintain a decreasing order
    // *** 4. add the index to queue addFirst
    // *** 3. start adding to res max array when i >= k-1 that is from index 2 for k=3
    private static List<Integer> findSlidingWindowMax(List<Integer> list, int k) {

        List<Integer> res = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();

        for(int i=0; i<list.size(); i++) {

            // remove out of range elements from deque we need to consider only k elements
            if(!deque.isEmpty() && i >= k) {
                deque.remove(i-k);
            }
            // maintain decreasing order
            while(!deque.isEmpty() && list.get(deque.peekFirst()) < list.get(i)) {
                deque.removeFirst();
            }
            deque.addLast(i);
            if(i >= k-1) {
                res.add(list.get(deque.peekFirst()));
            }
        }
        return res;
    }
}
