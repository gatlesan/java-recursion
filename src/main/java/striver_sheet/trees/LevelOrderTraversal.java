package striver_sheet.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(levelOrder(root));

    }

    // *** remember offer and poll for queues - peek() will retrieve but does not remove
    private static List<Integer> levelOrder(Node root) {

        List<Integer> ds = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            if(queue.peek().left != null) {
                queue.offer(queue.peek().left);
            }
            if(queue.peek().right != null) {
                queue.offer(queue.peek().right);
            }
            ds.add(queue.poll().data);
        }
        return ds;
    }
}
