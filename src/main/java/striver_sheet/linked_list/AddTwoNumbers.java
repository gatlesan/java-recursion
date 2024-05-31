package striver_sheet.linked_list;

public class AddTwoNumbers {

    public static void main(String[] args) {


        //*** remember if sum > 9 e.g. 12%10 you need to create node with 2
        //*** and 1 will be the carry, 12/10 will give the carry

        Node dummy = new Node(0);
        Node temp = dummy;

        /*Node l1 = new Node(2, new Node(4, new Node(3)));
        Node l2 = new Node(5, new Node(6, new Node(4)));*/

        Node l1 = new Node(9, new Node(9, new Node(9, new Node(9, new Node(9, new Node(9, new Node(9)))))));
        Node l2 = new Node(9, new Node(9, new Node(9, new Node(9))));

        int s = 0, c = 0, d = 0;

        while(l1 != null || l2 != null || c != 0) {
            if(l1 != null) {
                s = s + l1.data;
                l1 = l1.next;
            }
            if(l2 != null) {
                s = s + l2.data;
                l2 = l2.next;
            }
            if(c != 0) {
                s = s + c;
                c = 0;
            }
            if(s > 9) {
                d = s % 10;
                c = s / 10;
            } else {
                d = s;
            }
            temp.next = new Node(d);
            temp = temp.next;
            s = 0;
        }

        Node res = dummy.next;
        while(res != null) {
            System.out.print("---> "+res.data);
            res = res.next;
        }
    }
}
