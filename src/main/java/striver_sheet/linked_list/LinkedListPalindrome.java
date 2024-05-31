package striver_sheet.linked_list;

import java.util.ArrayList;

public class LinkedListPalindrome {


    public static void main(String[] args) {

        //BF... add all the nodes data to list and check if thie list is palidrome or not - two pointer approach
        //Optimal - find the middle node (slow and fast pointer) then reverse the right portion of the LL,
        //compare with two pointers head with middle+1 and so on ...


        Node r = new Node(1, new Node(2, new Node(3)));
        Node res = reverse(r);
        while(res!=null) {
            System.out.print("---> "+res.data);
            res = res.next;
        }
        System.out.println("------------------");

        Node head = new Node(1, new Node(2, new Node(1)));
        System.out.println(findMiddle(head).data);

        System.out.println(isPalindrome(head));
    }


    private static boolean isPalindrome(Node head) {

        // cases
        if(head == null || head.next == null) {
            return false;
        }

        // edge case...
        if(head.next.next == null) {
            return head.data == head.next.data;
        }

        Node middleNode = findMiddle(head);
        Node rPointer = reverse(middleNode.next);

        while(rPointer != null && head != middleNode) {
            if(rPointer.data == head.data) {
                rPointer = rPointer.next;
                head = head.next;
            } else {
                return false;
            }
        }
        return true;

    }

    private static Node reverse(Node node) {

        if(node.next == null) {
            return node;
        }
        Node head = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return head;
    }

    private static Node findMiddle(Node head) {

        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
