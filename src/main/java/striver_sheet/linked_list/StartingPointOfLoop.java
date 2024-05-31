package striver_sheet.linked_list;

import java.util.ArrayList;
import java.util.List;

public class StartingPointOfLoop {
    public static void main(String[] args) {

        Node node10 = new Node(10);
        Node node3 = new Node(3, new Node(4, new Node(3, new Node(6, node10))));
        node10.next = node3;
        Node head = new Node(1, new Node(2, node3));

        //System.out.println(findCycle(head).data);

        //System.out.println(findCyclePointers(head).data);

        System.out.println(findCycleStartRefactor(head).data);

    }


    //using extra memory O(n)
    private static Node findCycle(Node head) {

        List<Node> memo = new ArrayList<>();

        while(head.next != null) {
            if(memo.contains(head)) {
                return head;
            }
            memo.add(head);
            head = head.next;
        }
        return null;
    }


    //using slow and fast pointer
    //1. after first collision reset fast to head and proceed 1 step
    //2. return the second collision
    private static Node findCyclePointers(Node head) {

        if(head == null || head.next == null) {
            return null;
        }

        Node slow = head.next;
        Node fast = head.next.next;

        //first collision
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //no cycle
        if(slow == null || fast == null) {
            return null;
        }

        System.out.println("Collision "+slow.data);
        //reset fast
        fast = head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }


    private static Node findCycleStartRefactor(Node head) {

        Node slow = head;
        Node fast = head;

        //In case of no cycle fast will reach null first
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            //first collision
            if(slow == fast) {
                fast = head;
                while(slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
