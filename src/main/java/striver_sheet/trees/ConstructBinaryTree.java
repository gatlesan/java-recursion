package striver_sheet.trees;

import java.util.*;

public class ConstructBinaryTree {

    public static void main(String[] args) {

        List<Integer> in = Arrays.asList(40,20,50,10,60,30);
        List<Integer> pre = Arrays.asList(10,20,40,50,30,60);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<in.size();i++) {
            map.put(in.get(i), i);
        }
        Stack<Integer> stack = new Stack<>();
        for(int j=pre.size()-1;j>=0;j--) {
            stack.push(pre.get(j));
        }

        Node n = build(stack, 0, in.size()-1, in, map);
        System.out.println(n);
    }


    private static Node build(Stack<Integer> stack, int i, int j, List<Integer> in, Map<Integer, Integer> map) {

        if(i == j) {
            return new Node(in.get(i));
        }

        if(stack.isEmpty()) {
            return null;
        }

        Integer val = stack.pop();
        Node n = new Node(val);
        int m = map.get(val);
        n.left = build(stack, i, m-1, in, map);
        //backtracking... step
        stack.pop();
        n.right = build(stack, m+1, j, in, map);
        return n;
    }
}
