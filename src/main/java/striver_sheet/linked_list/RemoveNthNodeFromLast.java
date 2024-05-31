package striver_sheet.linked_list;

public class RemoveNthNodeFromLast {


    //*** remember you might have to unlink the first node
    //*** Always start with dummy node

    //TC - O(n) for getting the total count and O(n) for removing the links
    public static void main(String[] args) {
        Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5)))));
        Node dummy = new Node(0);
        dummy.next = head;

        Node start = dummy;

        Node t = head;

        //given
        int n = 2;

        int nodeCount = 0;
        while (t != null) {
            nodeCount++;
            t = t.next;
        }

        System.out.println("Node Count " + nodeCount);

        //stop @ node
        int s = (nodeCount - n);
        //LinkedList take count from 1 to count the nodes
        for(int i=1;i<=s;i++) {
            start = start.next;
        }

        System.out.println(start.data);

        start.next = start.next.next;

   /*     while(head != null) {
            System.out.print("---> "+head.data);
            head = head.next;
        }*/

        unlink(head, 2);
    }



    private static void unlink(Node head, int n) {

        Node dummy = new Node(0);
        dummy.next = head;

        Node slow = dummy;
        Node fast = dummy;

        //two pointer fast and slow
        //start fast and slow from dummy
        //fast will move till n and from there
        //fast and slow will move till fast.next != null
        //that is till fast stops at last node

        for(int i=1;i<=n;i++) {
            fast = fast.next;
        }

        System.out.println(fast.data);

        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        System.out.println(slow.data);
        System.out.println(fast.data);

        slow = slow.next;

        while(head != null) {
            System.out.print("---> "+head.data);
            head = head.next;
        }

    }
}
