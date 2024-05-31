package striver_sheet.linked_list;

public class LinkedListMiddle {

    public static void main(String[] args) {

        Node node = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5)))));

        Node n = findMiddleOptimal(node);
        while (n != null) {
            System.out.print("--> " + n.data);
            n = n.next;
        }

    }

    private static Node findMiddle(Node head) {

        int c = 0;
        Node head1 = head;
        while (head != null) {
            c++;
            head = head.next;
        }

        System.out.println(c);

        int m = c / 2;
        System.out.println(m);

        int r = 0;
        while (head1 != null) {
            if (r == m) {
                return head1;
            } else {
                r++;
                head1 = head1.next;
            }
        }

        return head1;
    }


    // Using slow and fast pointer O(n)
    private static Node findMiddleOptimal(Node head) {

        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
