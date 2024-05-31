package striver_sheet.trees;

public class LowestCommonAncestor {

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        Node res = lca(root, new Node(6), new Node(7));
        System.out.println(res.data);

    }

    //*** LCA - of (x,y) find the nodes till x store in ds and find the nodes till y store in ds
    //*** two pointer find n where i != j and n-1 is the common ancestor
    //*** TC: O(n) + O(n), SC: O(n) + O(n)

    //*** space optimization
    //*** Using DFS --> left and right until we find x return x if x is found at a node or return null(leaf)
    //*** At each node if left || right is not null return non-null val

    private static Node lca(Node node, Node x, Node y) {

        if(node == null || node.data == x.data || node.data == y.data) {
            return node;
        }

        Node ln = lca(node.left, x, y);
        Node rn = lca(node.right, x, y);

        if(ln != null && rn != null) {
            return node;
        }
        else if(ln != null) {
            return ln;
        } else if(rn != null) {
            return rn;
        } else {
            return null;
        }
    }
}
