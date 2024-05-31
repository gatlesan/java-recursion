package striver_sheet.trees;

import java.util.LinkedList;
import java.util.Queue;

public class DepthOfBinaryTree {

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.right = new Node(7);
        System.out.println(depthIterative(root));

        System.out.println(depth(root));
    }

    private static int depthIterative(Node node) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        int d = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                queue.poll();
            }
            d++;
        }
        return d;
    }

    private static int depth(Node node) {

        if(node == null) {
            return 0;
        }
        int leftDepth = 1 + depth(node.left);
        int rightDepth = 1 + depth(node.right);
        return Math.max(leftDepth, rightDepth);
    }
}
