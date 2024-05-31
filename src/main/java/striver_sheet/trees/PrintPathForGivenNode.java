package striver_sheet.trees;

import java.util.ArrayList;
import java.util.List;

public class PrintPathForGivenNode {

    public static void main(String[] args) {


        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.left.right.right = new Node(7);

        List<Integer> list = new ArrayList<>();
        Node target = new Node(7);
        findPath(root, target, list);
        System.out.println(list);

        //iterate from the last in list due to recursion list will be in reverse
        List<Integer> res = new ArrayList<>();
        res.add(root.data);
        for (int i = list.size()-1; i >= 0; i--) {
            res.add(list.get(i));
        }

        System.out.println(res);
    }

    private static boolean findPath(Node node, Node target, List<Integer> ds) {

        if (node == null) {
            return false;
        }

        if (node.data == target.data) {
            return true;
        }

        if (findPath(node.left, target, ds)) {
            ds.add(node.left.data);
            return true;
        } else if (findPath(node.right, target, ds)) {
            ds.add(node.right.data);
            return true;
        }

        return false;
    }
}
