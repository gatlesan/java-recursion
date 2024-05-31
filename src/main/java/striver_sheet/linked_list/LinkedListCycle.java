package striver_sheet.linked_list;

public class LinkedListCycle {

    public static void main(String[] args) {


        Node node2 = new Node(2);
        Node node3 = node2.next = new Node(3);
        Node node4 = node3.next = new Node(4);
        node4.next = node2;
        //node4.next = null;

        Node head = new Node(1, node2);


        //System.out.println(head.next == node4.next);

        //*** remember BF - use hashing or ArrayList of refs and check contains till reaches null;
        //*** O(n) + space complexity -> list size

        System.out.println(isCyclic(head));
    }

    private static boolean isCyclic(Node head) {

        //0 or 1 node cannot form a cycle
        if(head == null || head.next == null) {
            return false;
        }

        Node slow = head;
        Node fast = head;

        //first collision O(n)
        //do not use while --> slow != fast both are pointing to head

        //** fast will reach null first in case of non-cyclic
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) {
                //finding the collision is enough to prove that it is cyclic
                System.out.println(slow.data+" "+ fast.data);
                return true;
            }
        }

        return false;

    }

}
