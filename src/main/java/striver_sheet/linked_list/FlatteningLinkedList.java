package striver_sheet.linked_list;

public class FlatteningLinkedList {

    public static void main(String[] args) {
        
        //*** Using recursion to tackle last two lists merge them using merge sort logic and returns a new list and so on...

        Node node19 = new Node(19);
        node19.bottom = new Node(22);
        node19.bottom.bottom = new Node(50);

        Node node28 = new Node(28);
        node28.bottom = new Node(35);
        node28.bottom.bottom = new Node(40);
        node28.bottom.bottom.bottom = new Node(45);

        node19.next = node28;

        Node res = flat(node19);
        System.out.println(res);

    }
    
    
    private static Node flat(Node l1) {
        if(l1.next == null) {
            return l1;
        }
        Node l2 = flat(l1.next);
        return merge(l1, l2);
    }
    
    private static Node merge(Node l1, Node l2) {
        
        Node dummy = new Node(0);
        Node temp = dummy;
        //*** remember temp = temp.bottom
        while(l1 != null && l2 != null) {
            if(l1.data < l2.data) {
                temp.bottom = l1;
                l1 = l1.bottom;
            } else {
                temp.bottom = l2;
                l2 = l2.bottom;
            }
            temp = temp.bottom;
        }
        
        while(l1 != null) {
            temp.bottom = l1;
            l1 = l1.bottom;
        }

        while(l2 != null) {
            temp.bottom = l2;
            l2 = l2.bottom;
        }
        
        return dummy.bottom;
    }
    
    
    
}
