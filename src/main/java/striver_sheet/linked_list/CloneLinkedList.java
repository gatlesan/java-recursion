package striver_sheet.linked_list;

public class CloneLinkedList {

    public static void main(String[] args) {

        //*** BF. Create a HashMap create a map of original Node and Copy Node
        // then iterate the original node get the copy assign next and random using the original to clone...


        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.next = node2;
        node1.random = node4;

        node2.next = node3;
        node2.random = node1;

        node3.next = node4;
        node3.random = null;

        node4.next = null;
        node4.random = node2;

        Node head = node1;

        clone(head);

    }

    //*** 1. Create Copy nodes of the nodes and insert after the original node 1 --> copy1 ---> 2 ---> copy2 ---> 3
    //*** 2. take first node and get random pointer n.random assign to n.next.random = n.random.next i.e. copy1.random = n.random.next(which is a copy of random)
    //*** 3. Re-establish the links back on the original nodes
    //TC: O(n) + O(n) + O(n)
    private static Node clone(Node head) {

        Node temp = head;
        Node temp1 = head;
        Node temp2 = head;

        //1.step
        while (temp != null) {
            Node newNode = new Node(temp.data);
            Node t = temp.next;
            temp.next = newNode;
            newNode.next = t;
            temp = temp.next.next;
        }

        //2.step *** remember some nodes might not have any random handle null checks
        while (temp1 != null) {
            temp1.next.random = (temp1.random != null) ? temp1.random.next : null;
            temp1 = temp1.next.next;
        }

        //3.step *** remember to use the t to copy the ref and then break the links
        Node resHead = temp2.next;
        while (temp2 != null) {
            Node t = temp2.next.next;
            temp2.next.next = (temp2.next != null && temp2.next.next != null) ? temp2.next.next.next : null;
            temp2.next = t;
            temp2 = temp2.next;
        }


        return resHead;
    }
}
