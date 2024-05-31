package striver_sheet.trees;

import java.util.*;

public class PreInPostOrderSingleFlow {


    public static void main(String[] args) {

        // *** remember algo ---> tree which uses Stack :)
        // Pair --> Node, Integer(number 1, for pre, 2 for in and 3 for post)
        // prep: insert (node, 1) in stack
        // 1. pop if num == 1 --> add to pre, push same node ++num, and also push (left, 1)
        // 2. pop if num == 2 --> add to in, push same node ++num, and also push (right, 1)
        // 3. pop if num == 3 --> add to post


        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        printPreInPost(root);

    }

    private static void printPreInPost(Node root) {

        List<Integer> pre = new LinkedList<>();
        List<Integer> in = new LinkedList<>();
        List<Integer> post = new LinkedList<>();

        Stack<Pair> stack = new Stack<>();
        stack.add(new Pair(root, 1));

        while(!stack.isEmpty()) {
            Pair pair = stack.pop();
            if(pair.x == 1) {
                pre.add(pair.node.data);
                pair.x = pair.x+1;
                stack.add(pair);
                if(pair.node.left != null) {
                    stack.add(new Pair(pair.node.left, 1));
                }
            }
            else if(pair.x == 2) {
                in.add(pair.node.data);
                pair.x = pair.x+1;
                stack.add(pair);
                if(pair.node.right != null) {
                    stack.add(new Pair(pair.node.right, 1));
                }
            }
            else if(pair.x == 3) {
                post.add(pair.node.data);
            }
        }

        System.out.println("Pre "+pre);
        System.out.println("In "+in);
        System.out.println("Post "+post);

    }
}
