package striver_sheet.trees;

public class HeightBinaryTree {

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.right = new Node(7);
        System.out.println(findHeight(root));

    }

    // Find height in O(n)
    // Post order traversal
    private static int findHeight(Node node) {

        if(node == null) {
            return 0;
        }

        int lh = findHeight(node.left);
        int rh = findHeight(node.right);
        return Math.max(lh,rh) + 1;
    }
}
