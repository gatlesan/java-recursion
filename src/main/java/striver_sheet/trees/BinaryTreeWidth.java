package striver_sheet.trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeWidth {

    public static void main(String[] args) {


        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(findWidth(root));

    }

    // *** Segment trees
    // *** Width - Max number of nodes between two nodes in a level
    // 1. level order traversal
    // 2. at a given level max(lastNodeIndex - firstNodeIndex + 1) will be the answer

    // assign index to each node in level order traversal
    // 0 based indexing i(root i = 0) --> left -- 2*i+1 and right -- 2*i + 2 (If we twice the val, chances of int overflow)
    // 2*(index-prevMinIndex)+1 and 2*(index-prevMinIndex)+2
    // try to index from 1 to n in every level...
    // 1. poll - all the nodes, first = 0 and last = 0
    // 2. queue each node with index
    // 3. max(res, last-first+1)

    // *** remember to do nodeIndexPair.node.left not node.right will result in infinite loop
    private static int findWidth(Node node) {

        Queue<NodeIndexPair> queue = new LinkedList<>();
        queue.offer(new NodeIndexPair(node, 0));
        int first = 0;
        int prevMinIndex = first;
        int firstIndex = 0;
        int last = 0;
        int res = Integer.MIN_VALUE;
        while(!queue.isEmpty()) {
            int size = queue.size();
            System.out.println("size "+size);
            for (int i = 0; i < size; i++) {
                NodeIndexPair nodeIndexPair = queue.poll();
                int index = nodeIndexPair.index;
                first = 2*(index-prevMinIndex)+1;
                if(firstIndex == 0) {
                    firstIndex = first;
                }
                if(nodeIndexPair.node.left != null) {
                    queue.offer(new NodeIndexPair(nodeIndexPair.node.left, first));
                }
                if(nodeIndexPair.node.right != null) {
                    //this is important we will only consider the nodes in between first and last ...
                    last = 2*(index-prevMinIndex)+2;
                    queue.offer(new NodeIndexPair(nodeIndexPair.node.right, last));
                }
            }
            System.out.println("queue "+queue);
            System.out.println("first "+firstIndex + " last "+last);
            res = Math.max(res, (last - firstIndex) + 1);
            prevMinIndex = firstIndex;
            System.out.println("---------------- "+prevMinIndex);
        }
        return res;
    }
}

class NodeIndexPair {

    int index;
    Node node;

    NodeIndexPair(Node node, int index) {
        this.node = node;
        this.index = index;
    }

    @Override
    public String toString() {
        return "NodeIndexPair{" +
                "index=" + index +
                ", node=" + node +
                '}';
    }
}
