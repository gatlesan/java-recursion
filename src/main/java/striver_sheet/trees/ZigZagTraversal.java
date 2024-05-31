package striver_sheet.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversal {

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(8);
        root.right.right.right = new Node(9);
        System.out.println(traversal(root));

    }

    // Intuition is to use Level order traversal with for loop
    // Pattern: LOT for loop
    // flag == 0 L -> R, flag == 1, R -> L
    private static List<Integer> traversal(Node node) {

        Queue<Node> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        queue.offer(node);
        res.add(node.data);
        int flag = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node n = queue.poll();
                if (n.left != null) {
                    queue.offer(n.left);
                }
                if (n.right != null) {
                    queue.offer(n.right);
                }
                if (flag == 1) {
                    if (n.right != null)
                        res.add(n.right.data);
                    if (n.left != null)
                        res.add(n.left.data);
                } else {
                    if (n.left != null)
                        res.add(n.left.data);
                    if (n.right != null)
                        res.add(n.right.data);
                }
            }
            flag = Math.abs(flag - 1);
        }

        return res;
    }
}
