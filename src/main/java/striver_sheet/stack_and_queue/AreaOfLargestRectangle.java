package striver_sheet.stack_and_queue;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class AreaOfLargestRectangle {

    public static void main(String[] args) {

        // *** remember the formula
        // *** (rsi-lsi)-1 * a[i]  w*h
        // BF: i --> run right for loop find the rsi and run another for loop for left to find lsi O(n * 2n) ~ O(n^2)

        // System.out.println(findArea(Arrays.asList(2, 1, 5, 6, 2, 3)));

        int maxArea = findAreaUsingStack(Arrays.asList(2, 1, 5, 6, 2, 3));
        System.out.println(maxArea);
    }

    //BF
    private static int findArea(List<Integer> list) {

        int maxArea = 0;
        int minRightIndex = list.size();
        int minLeftIndex = -1;

        for (int i = 0; i < list.size(); i++) {

            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j) < list.get(i)) {
                    minRightIndex = j;
                    break;
                } else {
                    minRightIndex = list.size();
                }
            }

            for (int k = i - 1; k >= 0; k--) {
                if (list.get(k) < list.get(i)) {
                    minLeftIndex = k;
                    break;
                } else {
                    minLeftIndex = -1;
                }
            }
            int area = ((minRightIndex - minLeftIndex) - 1) * list.get(i);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }


    // *** Find Area using stack data structure
    // formula (rsi-lsi+1)*a[i]
    // push indexes to the stack which can be used to find the greater and smaller elements
    // push index-1 in to the stack for rsi and index+1 form lsi
    // for no small element on right use n-1 that is 6 for 7 elements
    // for no small on the left use 0\
    // 2, 1, 5, 6, 2, 3
    private static int findAreaUsingStack(List<Integer> list) {

        int size = list.size();
        Stack<Integer> stack = new Stack<>();
        int[] leftSmallIndexArray = new int[list.size()];
        int[] rightSmallIndexArray = new int[list.size()];

        for(int i=size-1;i>=0;i--) {
            while(!stack.isEmpty() && list.get(stack.peek()) >= list.get(i)) {
                stack.pop();
            }
            leftSmallIndexArray[i] = !stack.isEmpty() ? stack.peek()-1 : size-1;
            stack.push(i);
        }

        System.out.println(Arrays.stream(leftSmallIndexArray).boxed().collect(Collectors.toList()));

        //empty stack to reuse
        while(!stack.isEmpty()) {
            stack.pop();
        }

        for(int j=0;j<size;j++) {
            while(!stack.isEmpty() && list.get(stack.peek()) >= list.get(j)) {
                stack.pop();
            }
            rightSmallIndexArray[j] = !stack.isEmpty() ? stack.peek()+1 : 0;
            stack.push(j);
        }

        System.out.println(Arrays.stream(rightSmallIndexArray).boxed().collect(Collectors.toList()));

        int maxArea = 0;
        for(int i=0;i<size;i++) {
            maxArea = Math.max(maxArea, (leftSmallIndexArray[i] - rightSmallIndexArray[i] + 1) * list.get(i));
        }
        return maxArea;
    }


    // *** (rsi-lsi+1)*a[i]
    // *** starting from 0 we find rsi at rsi find maxArea of all the elements in stack...
    private static int findAreaUsingOnePassStack(List<Integer> list) {

        return 0;
    }
}
