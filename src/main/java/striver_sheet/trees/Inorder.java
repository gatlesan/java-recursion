package striver_sheet.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Inorder {

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

        List<Integer> inorderList = new ArrayList<>();
        InOrderIterative(root, inorderList);
        System.out.println(inorderList);

        List<Integer> preOrderList = new ArrayList<>();
        preOrderIterative(root, preOrderList);
        System.out.println(preOrderList);
    }

    private static void InOrderIterative(Node node, List<Integer> inorderList) {

        Stack<Node> stack = new Stack<>();

        while(true) {

            if(node != null) {
                stack.push(node);
                node = node.left;
            } else {
                if(stack.isEmpty()) {
                    return;
                }
                Node curr = stack.pop();
                inorderList.add(curr.data);
                node = curr.right;
            }
        }

    }

    // *** remember we always push the current node
    private static void preOrderIterative(Node node, List<Integer> preOrderList) {

        Stack<Node> stack = new Stack<>();

        while(true) {

            if(node != null) {
                preOrderList.add(node.data);
                stack.push(node);
                node = node.left;
            } else {
                if(stack.isEmpty()) {
                   return;
                }
                Node temp = stack.pop();
                node = temp.right;
            }

        }

    }
}


class Node {

    int data = 0;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
    }

    Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
