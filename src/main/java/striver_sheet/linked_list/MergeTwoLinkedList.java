package striver_sheet.linked_list;

public class MergeTwoLinkedList {

    public static void main(String[] args) {

        Node head1 = new Node(3, new Node(7, new Node(10, null)));
        Node head2 = new Node(1, new Node(2, new Node(5, new Node(8, new Node(10, null)))));
        Node node = merge(head1, head2);
        while(node != null) {
            System.out.print("---> "+node.data);
            node = node.next;
        }

    }


    //**** Remember do not assign node = node.next this will break the link
    private static Node merge(Node head1, Node head2) {

        Node node = null;



        while (head1 != null && head2 != null) {
            if(head1.data < head2.data) {
                if(node == null) {
                    node = new Node(head1.data);
                } else {
                    node.next = new Node(head1.data);
                }
                head1 = head1.next;
            } else {
                if(node == null) {
                    node = new Node(head2.data);
                } else {
                    node.next = new Node(head2.data);
                }
                head2 = head2.next;
            }
        }

        //copy the remaining from left
        while(head1 != null) {
            node.next = new Node(head1.data);
            head1 = head1.next;
        }

        //copy the remaining from right
        while(head2 != null) {
            node.next = new Node(head2.data);
            head2 = head2.next;
        }

        return node;

    }
}
