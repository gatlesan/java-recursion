package hacker_rank;

public class MergedTwoSortedLinkedList {

    public static void main(String[] args) {

        SinglyLinkedListNode head1 = new SinglyLinkedListNode(1);
        SinglyLinkedListNode h = new SinglyLinkedListNode(3);
        head1.next = h;
        h.next = new SinglyLinkedListNode(7);

        SinglyLinkedListNode head2 = new SinglyLinkedListNode(1);
        SinglyLinkedListNode h2 = new SinglyLinkedListNode(2);
        head2.next = h2;

  /*      while(head1!=null) {
            System.out.print(head1.data + " --> ");
            head1 = head1.next;
        }
        System.out.println("");
        while(head2!=null) {
            System.out.print(head2.data + " --> ");
            head2 = head2.next;
        }*/

        SinglyLinkedListNode res = mergeLists(head1, head2);
        System.out.println(res);
        while (res != null) {
            System.out.print(res.data + " --> ");
            res = res.next;
        }
    }

    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

        SinglyLinkedListNode head = null;
        SinglyLinkedListNode newHead = null;

        while (head1 != null || head2 != null) {
            if (head1 == null) {
                if (newHead == null) {
                    newHead = new SinglyLinkedListNode(head2.data);
                    head = newHead;
                } else {
                    newHead.next = new SinglyLinkedListNode(head2.data);
                    newHead = newHead.next;
                }
                head2 = head2.next;
            } else if (head2 == null) {
                if (newHead == null) {
                    newHead = new SinglyLinkedListNode(head1.data);
                    head = newHead;
                } else {
                    newHead.next = new SinglyLinkedListNode(head1.data);
                    newHead = newHead.next;
                }
                head1 = head1.next;
            } else if (head1.data <= head2.data) {
                if (newHead == null) {
                    newHead = new SinglyLinkedListNode(head1.data);
                    head = newHead;
                } else {
                    newHead.next = new SinglyLinkedListNode(head1.data);
                    newHead = newHead.next;
                }
                head1 = head1.next;
            } else {
                if (newHead == null) {
                    newHead = new SinglyLinkedListNode(head2.data);
                    head = newHead;
                } else {
                    newHead.next = new SinglyLinkedListNode(head2.data);
                    newHead = newHead.next;
                }
                head2 = head2.next;
            }
        }

        return head;
    }


    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }
}
