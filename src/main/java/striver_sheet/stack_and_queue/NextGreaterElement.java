package striver_sheet.stack_and_queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NextGreaterElement {

    public static void main(String[] args) {

        // *** finding next greater element in an array
        // *** Intuition is to use stack to keep track of greater elements starting from n-1
        // *** if element is greater than the stack top pop until the value is greater and use it or else return -1 if not values exists in the stack

        System.out.println(findNGEArrayOptimal(Arrays.asList(3, 10, 4, 2, 1, 2, 6, 1, 7, 2, 9)));

    }


    // *** remember to do stack isempty for all stack operations peek and pop
    private static List<Integer> findNGEArray(List<Integer> list) {

        int[] res = new int[list.size()];
        Stack<Integer> stack = new Stack<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= list.get(i)) {
                stack.pop();
            }
            res[i] = !stack.isEmpty() ? stack.peek() : -1;
            stack.push(list.get(i));
        }

        //handle the last element which is set to -1 initially...
        //Due to this problem we need to work of imaginary array of same elements copied next to list
        //which starts from (2*n-1) and only populate the res if i < n
        while (!stack.isEmpty() && stack.peek() < list.get(list.size() - 1)) {
            stack.pop();
        }
        res[res.length - 1] = !stack.isEmpty() ? stack.peek() : -1;

        return Arrays.stream(res).boxed().collect(Collectors.toList());
    }

    private static List<Integer> findNGEArrayOptimal(List<Integer> list) {

        int n = list.size();
        int[] res = new int[list.size()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * (n - 1); i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= list.get(i%n)) {
                stack.pop();
            }
            if (i < n)
                res[i] = !stack.isEmpty() ? stack.peek() : -1;
            stack.push(list.get(i%n));
        }
        return Arrays.stream(res).boxed().collect(Collectors.toList());
    }

}
