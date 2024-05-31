package striver_sheet.linked_list;

import java.util.Arrays;
import java.util.List;

public class RotateLinkedList {

    public static void main(String[] args) {

        //BF: Create an array of LL and create a new LL using the rotated list... O(kxN) space: O(N) to create a new LL
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        //System.out.println(rotate(list, 14));

        Node head = new Node(1, new Node(2, new Node(3, new Node(4))));
        rotateOptimal(head, 15);

    }


    //O(kxn)
    private static List<Integer> rotate(List<Integer> list, int k) {

        //*** when k == size of the list elements will be in the same position in the end...
        //*** k can be reduced to smaller value
        if (k > list.size()) {
            if (k % list.size() == 0)
                return list;
            else
                k = k % list.size();
        }

        while (k > 0) {
            int temp = list.get(list.size() - 1);
            for (int i = list.size() - 2; i >= 0; i--) {
                list.set(i + 1, list.get(i));
            }
            list.set(0, temp);
            k--;
        }
        return list;
    }

    //1. Find len
    //2. Reduce k if k > size
    //3. point the last node to head
    //4. move the head k times, where k = (size - k) --> important
    //5. assign head to k.next.... h = k.next
    //6. make k = null
    private static Node rotateOptimal(Node head, int k) {

        Node temp = head;
        int size = 1;
        while (head.next != null) {
            size++;
            head = head.next;
        }

        if (k >= size) {
            if (k % size == 0) {
                return head;
            } else {
                k = k % size;
            }
        }

        head.next = temp;
        k = size-k;
        //*** temp should stop @kth node
        while(k != 1) {
            k--;
            temp = temp.next;
        }

        Node n = temp.next;
        temp.next = null;
        return n;


    }
}
