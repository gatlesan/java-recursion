package arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;


// Finding the median using minHeap and maxHeap
// maxHeap (get max number) minHeap (get min number)
// medain left elements are smaller and right elements are larger
// peek on left(maxHeap) will give left element
// peek on right(minHeap) will give right element
public class FindMedianPQ {

    static class FindMedian {
        static PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        static PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        static void insertNum(int num) {
            if(maxHeap.isEmpty() || maxHeap.peek() >= num)
                maxHeap.add(num);
            else {
                minHeap.add(num);
            }

            //balance the heaps
            if(maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            } else if(maxHeap.size() < minHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
        }

        static void removeNum(int num) {
            if(maxHeap.isEmpty() || maxHeap.peek() >= num)
                maxHeap.remove(num);
            else {
                minHeap.remove(num);
            }
        }


        // O(1)
        static int findMedian() {
            int total = maxHeap.size() + minHeap.size();
            if(total%2 == 0) {
                return (maxHeap.peek() + minHeap.peek())/2;
            } else {
                return maxHeap.peek();
            }
        }
    }




    public static void main(String[] args) {

        int n=200000;
        int d=10000;
        List<Integer> list = Arrays.asList();

        for(Integer a : list) {
            FindMedian.insertNum(a);
        }

        System.out.println(FindMedian.findMedian());

        FindMedian.insertNum(1);

        System.out.println(FindMedian.findMedian());

        // convert double to int
        // System.out.println(a);




    }

    // O(long(n))

}
