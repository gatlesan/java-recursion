package striver_sheet.trees;

public class BalancedTree {

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.right = new Node(7);
        root.right.right.right.right = new Node(7);
        root.right.right.right.right.right = new Node(7);
        root.right.right.right.right.right.right = new Node(7);

        System.out.println(isBalanced(root));

    }

    // *** use the same logic of finding the height - recursion max(lh, rh) + 1
    // *** tweak it to return -1 if abs(lh-rh) > 1 and no need to find height if that happens
    private static boolean isBalanced(Node node) {
        return findHeight(node) != -1;
    }

    private static int findHeight(Node node) {
        if (node == null) {
            return 0;
        }

        int lh = findHeight(node.left);
        if (lh == -1)
            return -1;
        int rh = findHeight(node.right);
        if (rh == -1)
            return -1;
        if (Math.abs(lh - rh) > 1) {
            return -1;
        }
        return Math.max(lh, rh) + 1;
    }
}
