package striver_sheet.trees;

import java.util.*;

public class BottomViewOfBinaryTree {

    // *** level traversal -- using queue
    // *** maintain a Map<Integer, Node> map of x-coordinate and node
    // *** map should sort the x-axis in asc order -2,-1,0,1,2,3
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

        System.out.println(bottomView(root));
    }

    // *** remember map.entrySet will return Map.Entry on which map.getKey() map.getValue()
    // *** using TreeMap to get the result from left to right -2, -1, 0, 1, ...
    private static List<Integer> bottomView(Node root) {

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        Map<Integer, Integer> res = new TreeMap<>();
        List<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            Node node = pair.node;
            if (node.left != null) {
                // Be careful with passing values do not assign and pass, pass the updated value
                queue.add(new Pair(node.left, pair.x - 1));
            }
            if (node.right != null) {
                queue.add(new Pair(node.right, pair.x + 1));
            }
            // minor change for top view
            // res.put(pair.x, node.data);
            if(res.get(pair.x) == null) {
                res.put(pair.x, node.data);
            }
        }
        // *** remember this...
        for (Map.Entry<Integer, Integer> s : res.entrySet()) {
            result.add(s.getValue());
        }
        return result;
    }
}

class Pair {

    Node node;
    Integer x;

    Pair(Node node, Integer x) {
        this.node = node;
        this.x = x;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "node=" + node +
                ", x=" + x +
                '}';
    }
}