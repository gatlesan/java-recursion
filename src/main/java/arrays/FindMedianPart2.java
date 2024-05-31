package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class FindMedianPart2 {
    public static void main(String[] args) throws IOException {
        // List<Integer> expenditure = Arrays.asList();

        int d = 10000;


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> expenditure = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
        System.out.println(expenditure.size());
        System.out.println(activityNotifications(expenditure, d));


    }

    public static int activityNotifications(List<Integer> expenditure, int d) {
        // Write your code here
        MedianPriorityQueue medianPriorityQueue = new MedianPriorityQueue();
        int n = expenditure.size();
        int c = 0;
        int j = 0;
        if (n < d + 1) {
            return c;
        } else {
            for (int i = 0; i < n; i++) {
                if (i > d - 1) {
                    if (expenditure.get(i) >= 2 * Math.ceil(medianPriorityQueue.findMedian()))
                        c++;
                    medianPriorityQueue.removeNum(expenditure.get(i-d));
                }
                medianPriorityQueue.insertNum(expenditure.get(i));
            }
        }
        return c;
    }

    public static class MedianPriorityQueue {

        static PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        static PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

        void insertNum(int num) {
            if (maxHeap.isEmpty() || maxHeap.peek() >= num)
                maxHeap.add(num);
            else {
                minHeap.add(num);
            }

            //balance the heaps
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            } else if (maxHeap.size() < minHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
        }

        void removeNum(int num) {
            if (maxHeap.isEmpty() || maxHeap.peek() >= num)
                maxHeap.remove(num);
            else {
                minHeap.remove(num);
            }

            //balance the heaps
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            } else if (maxHeap.size() < minHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
        }


        // O(1)
        double findMedian() {
         /*   int total = maxHeap.size() + minHeap.size();
            if(total%2 == 0) {
                return (maxHeap.peek() + minHeap.peek())/2.0;
            } else {
                return maxHeap.peek();
            }*/
            if (maxHeap.size() == minHeap.size()) {
                // take average
                return (maxHeap.peek() + minHeap.peek()) / 2.0;
            } else if (maxHeap.size() - minHeap.size() == 1) {
                // maxHeap has median
                return maxHeap.peek();
            } else {
                // minHeap has median
                return minHeap.peek();
            }

        }
    }
}
