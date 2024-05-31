package striver_sheet.linked_list;

public class DeleteCurrentNode {

    public static void main(String[] args) {

        // Node node = new Node(1, new Node(4, new Node(2, new Node(3))));
        Node node = new Node(1, new Node(2, new Node(3, new Node(4))));
        Node c = node;

        c.data = c.next.data;
        c.next = c.next.next;

        while(node != null) {
            System.out.print("---> "+node.data);
            node = node.next;
        }
    }
}
