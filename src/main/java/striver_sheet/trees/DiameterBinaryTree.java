package striver_sheet.trees;

public class DiameterBinaryTree {
    public static void main(String[] args) {

        int[] res = new int[1];
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.right = new Node(7);
        diameter(root, res);
        System.out.println(res[0]);

    }

    // Diameter - the longest path between two nodes
    // Path may or may not pass the root

    //*** Find leftHeight and rightHeight at every node using recursive function
    //*** We have to find the max(maxi, lh+rh);
    //*** repeat this for all nodes - recursively ---> O(n^2)

    //*** finding in O(n)
    // 1. find max LeftHeight
    // 2. find max RightHeight

    //*** remember to pass int[] array or List for the ref in recursion
    //*** Diameter at given Curving Point = Left Height + Right Height (links)
    private static int diameter(Node node, int[] dia) {

        if(node == null) {
            return 0;
        }

        int lh = diameter(node.left, dia);
        int rh = diameter(node.right, dia);
        dia[0] = Math.max(dia[0], lh+rh);
        return 1 + Math.max(lh,rh);
    }
}
