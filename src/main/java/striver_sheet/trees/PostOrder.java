package striver_sheet.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrder {

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(8);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);

        List<Integer> postOrderList = new ArrayList<>();
        postOrderIterative(root, postOrderList);
        System.out.println(postOrderList);

    }

    // Left, Right, Self
    // *** Using two stacks for iterative
    // 1. push root to s1
    // 2. pop and push to s2 and push left and right to s1
    // 3. repeat until s1 is empty
    // 4. s2 will have the result pop and add to res array
    private static List<Integer> postOrderIterative(Node node, List<Integer> list) {

        Stack<Node> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        if (node != null) {
            s1.push(node);
        }

        while (!s1.isEmpty()) {
            Node temp = s1.pop();
            s2.push(temp.data);
            if (temp.left != null)
                s1.push(temp.left);
            if (temp.right != null)
                s1.push(temp.right);
        }

        while(!s2.isEmpty()) {
            list.add(s2.pop());
        }
        return list;
    }


}
