package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class FindMedianPart3 {


    static PriorityQueue<Integer> lower = new PriorityQueue<Integer>(Collections.reverseOrder());
    static PriorityQueue<Integer> upper = new PriorityQueue<Integer>();


    public static void main(String[] args) throws IOException {

        int n = 5;
        int d = 3;

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> exp = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(","))
                .map(Integer::parseInt)
                .collect(toList());


        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = exp.get(i);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i-d > -1) {  //3
                double median;
                if (upper.size() == lower.size()) {
                    median = (upper.peek() + lower.peek()) / 2.0;
                }
                else if (upper.size() > lower.size()) {
                    median = upper.peek();
                }
                else {
                    median = lower.peek();
                }
                if (arr[i] >= median * 2) {
                    count++;
                }
                if (arr[i - d] <= lower.peek()) {
                    lower.remove(arr[i - d]);
                    if (lower.size() + 1 < upper.size()) {
                        lower.add(upper.poll());
                    }
                }
                else {
                    upper.remove(arr[i - d]);
                    if (upper.size() + 1 < lower.size()) {
                        upper.add(lower.poll());
                    }
                }
            }
            addToPQ(arr[i]);
        }


        System.out.println(count);
    }


    private static void addToPQ(int val) {
        if (lower.size() == 0 && upper.size() == 0) {
            lower.add(val);
        }
        else if (upper.size() == 0) {
            if (val < lower.peek()) {
                lower.add(val);
                upper.add(lower.poll());
            }
            else {
                upper.add(val);
            }
        }
        else if (Math.abs(lower.size() - upper.size()) == 1) {
            if (lower.size() < upper.size()) {
                if (lower.peek() !=null && val < lower.peek()) {
                    lower.add(val);
                }
                else {
                    upper.add(val);
                    lower.add(upper.poll());
                }
            }
            else {
                if (val > upper.peek()) {
                    upper.add(val);
                }
                else {
                    lower.add(val);
                    upper.add(lower.poll());
                }
            }
        }
        else {
            if (lower.peek() != null && val < lower.peek()) {
                lower.add(val);
            }
            else {
                upper.add(val);
            }
        }
    }
}
