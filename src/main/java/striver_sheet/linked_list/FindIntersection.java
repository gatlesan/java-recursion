package striver_sheet.linked_list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindIntersection {

    public static void main(String[] args) {

        Node node = new Node(1, new Node(3, new Node(1, new Node(2, new Node(4)))));
        Node i1 = node.next.next.next;
        Node node1 = new Node(3,i1);


        Node i2 = node1.next;
        i1 = i2;

        System.out.println(i1);
        System.out.println(i2);

        System.out.println(findRefactor(node, node1));
    }

    //O(n) + O(m)
    //list of refs
    private static Node find(Node node1, Node node2) {
        List<Node> list = new ArrayList<>();
        while (node1 != null) {
            list.add(node1);
            node1 = node1.next;
        }

        System.out.println(list);

        while (node2 != null) {
            if (list.contains(node2)) {
                return node2;
            }
            node2 = node2.next;
        }
        return null;
    }

    //optimal
    //d1 and d2 when one of them is null interchange the heads
    private static Node find1(Node head1, Node head2) {

        Node d1 = head1;
        Node d2 = head2;

        while(d1 != null || d2 != null) {
            if(d1 == d2) {
                return d1;
            }
            else if(d1 == null) {
                d1 = head2;
                d1 = d1.next;
                d2 = d2.next;
            } else if(d2 == null) {
                d2 = head1;
                d2 = d2.next;
                d1 = d1.next;
            } else {
                d1 = d1.next;
                d2 = d2.next;
            }
        }
        return null;
    }

    private static Node findRefactor(Node head1, Node head2) {

        Node d1 = head1;
        Node d2 = head2;

        while(d1 != null || d2 != null) {
            if(d1 == d2) {
                return d1;
            }
            d1 = (d1 == null) ? head2 : d1.next;
            d2 = (d2 == null) ? head1 : d2.next;
        }
        return null;
    }
}
