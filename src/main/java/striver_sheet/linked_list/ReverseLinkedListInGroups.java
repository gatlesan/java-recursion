package striver_sheet.linked_list;

import java.util.ArrayList;
import java.util.List;

public class ReverseLinkedListInGroups {

    public static void main(String[] args) {

        //*** reverse LL in general
        //*** 1. using stack to push all the nodes and then pop them one by one and create a new LL
        //*** 2. Using prev and curr pattern
        //*** 3. Recursion


        Node node = new Node(1, new Node(2, new Node(3, new Node(4))));
        Node prev = null;
        Node curr = node;
        while(curr != null) {
            Node t = curr.next;
            curr.next = prev;
            prev = curr;
            curr = t;
        }
        Node itr = prev;
 /*       while(itr != null) {
            System.out.print("---> "+itr.data);
            itr = itr.next;
        }*/

        //using recursion
        //Node dummy = new Node(0);
        //dummy.next = node;
        Node node4 = new Node(4);
        Node node1 = new Node(1, new Node(2, new Node(3, node4)));
        Node res = usingRecursion(node1);
        System.out.println(res.next.data);



        Node n = new Node(1,new Node(2, new Node(3, new Node(4, new Node(5, new Node(6, new Node(7, new Node(8))))))));
        reverseInGroups(n, 3);







    }

    private static Node usingRecursion(Node node) {

        if(node.next == null) {
            return node;
        }
        Node n = usingRecursion(node.next);
        //**** logic was right remember (node.next).next is 4 --> 3
        node.next.next = node;
        node = null;
        return n;
    }

    private static void reverseInGroups(Node head, int k) {

        Node temp = head;
        int len = 0;
        while(temp!=null) {
            len++;
            temp = temp.next;
        }

        Node dummy = new Node(0);

        Node curr = head;
        Node start = head;
        Node newHead = null;
        Node prevRef = new Node(0);
        while(curr != null && len >= k) {

            if(curr.data % 3 == 0) {
                Node temp1 = curr.next;
                if(newHead == null) {
                    newHead = curr;
                }
                Node newRef = reverse(start,curr);
                //tricky here...linking the groups...
                System.out.println("Group starting ----> "+newRef.data);
                start = temp1;
                curr = temp1;
                len = len - k;
            }

            curr = curr.next;
        }

        //refs--> 3->2->1 (3 as ref) 6->5->4 (6 as ref)
    }

    private static Node reverse(Node s, Node e) {
        Node t = e;
        recurs(s,e);
        return t;
    }

    private static Node recurs(Node c, Node e) {

        if(c == e) {
            return c;
        }
        Node ref = recurs(c.next,e);
        c.next.next = c;
        c.next = null;
        return ref;
    }
}
