package arrays;

import java.util.*;

public class MedianFinderPriorityQueue {


    public static class MedianPriorityQueue {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        public void addNum(int num) {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());

            if(maxHeap.size() < minHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
        }

        public int findMedian() {
            if(maxHeap.size() == minHeap.size()) {
                return (maxHeap.peek() + minHeap.peek()) / 2;
            }
            return minHeap.peek();
        }
    }

    public static void main(String[] args) {
       // List<Integer> expenditure = Arrays.asList(2,3,4,2,3,6,8,4,5,10);




        List<Integer> expenditure = Arrays.asList(2,3,4,2,3,6,8,4,5,10);
        int d =5;
        int n =expenditure.size();
        int c = 0;
        int j =0;
        if(n <= d+1) {
            System.out.println("Notifications "+c);
        } else {
            for(int i=0; i<n && (i+d)<n; i++) {
                j = i+d;
                if(expenditure.get(j) >= (2*getMedian(i, j, expenditure))) {
                    c++;
                }
            }

        }
        System.out.println(expenditure);
        System.out.println("Notifications "+c);
    }
    private static int getMedian(int s, int e, List<Integer> list) {
        MedianPriorityQueue medianPriorityQueue = new MedianPriorityQueue();
        for(int num: list.subList(s,e)) {
            medianPriorityQueue.addNum(num);
        }
        int m = medianPriorityQueue.findMedian();
        System.out.println(m);
        return m;
    }



}
