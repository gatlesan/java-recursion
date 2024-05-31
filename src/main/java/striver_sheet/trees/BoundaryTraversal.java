package striver_sheet.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BoundaryTraversal {

    public static void main(String[] args) {

        //*** Remember sometimes iterative is less complex than recursive based on the problem statement
        //*** for right and left boundary we will go with iterative approach

        //*** anti-clockwise boundary traversal ***//
        // *** can't use level order traversal because it will miss the last node ***//

        // 1. left if no left right and left till one above leaf node
        // 2. Inorder traversal to find all the leaf nodes
        // 3. Use a stack to keep track of the nodes for right traversal and pop as we need them in reverse order ***//

        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.left.right = new Node(4);
        root.left.left.right.left = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(7);
        root.right.right = new Node(8);
        root.right.right.left = new Node(9);
        root.right.right.left.left = new Node(10);
        root.right.right.left.right = new Node(11);
        List<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        boundaryTraversal(root, stack, res);
        System.out.println(res);
    }


    private static void boundaryTraversal(Node node, Stack<Integer> stack, List<Integer> res) {

        if (node == null) {
            return;
        }

        res.add(node.data);
        leftRightTraversal(node.left, res);
        findLeafNodes(node, res);
        rightLeftTraversalReverse(node.right, stack);
        System.out.println(stack);
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }

    }

    private static boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    // iteratively go left or right until leaf node
    private static void leftRightTraversal(Node node, List<Integer> res) {

        while (node != null) {
            if (isLeaf(node)) {
                return;
            }
            res.add(node.data);
            if (node.left != null)
                node = node.left;
            else if (node.right != null)
                node = node.right;
        }
    }

    // *** remember leaf nodes are nodes where node.left && node.right == null
    private static void findLeafNodes(Node node, List<Integer> leafNodes) {

        if (node == null) {
            return;
        } else if (isLeaf(node)) {
            leafNodes.add(node.data);
            return;
        }
        findLeafNodes(node.left, leafNodes);
        findLeafNodes(node.right, leafNodes);
    }

    // iteratively go right or left until leaf node
    private static void rightLeftTraversalReverse(Node node, Stack<Integer> stack) {

        while (node != null) {
            if (isLeaf(node)) {
                return;
            }
            stack.add(node.data);
            if (node.right != null)
                node = node.right;
            else if (node.left != null)
                node = node.left;
        }
    }
}
