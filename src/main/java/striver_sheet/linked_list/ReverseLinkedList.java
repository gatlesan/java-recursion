package striver_sheet.linked_list;

import java.util.LinkedList;
import java.util.Stack;

class Node {
    int data;
    Node next;

    Node bottom;

    Node random;

    Node(int data) {
        this.data = data;
    }

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    Node(int data, Node next, Node bottom) {
        this.data = data;
        this.next = next;
        this.bottom = bottom;
    }
}

public class ReverseLinkedList {

    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();
        list.add(0, 1);
        list.add(1, 2);
        list.add(2, 3);
        list.add(3, 4);

        Node node = new Node(1, new Node(2, new Node(3, new Node(4))));


  /*      while(node != null) {
            System.out.print("--> "+node.data);
            node = node.next;
        }*/


        // reverse(node);
        // reverseUsingPointers(node);

        Node newHead = reverseOptimal(node);
        while(newHead!=null) {
            System.out.print("---> "+newHead.data);
            newHead = newHead.next;
        }

    }


    //using stack
    private static void reverse(Node node) {

        Stack<Integer> stack = new Stack<>();
        while(node != null) {
            stack.push(node.data);
            node = node.next;
        }

        Node newNode = new Node(stack.pop().intValue());
        System.out.println(newNode);
        Node head = newNode;
        System.out.println(head);
/*        head.next = new Node(stack.pop().intValue());
        head.next.next = new Node(stack.pop().intValue());
        head.next.next.next = new Node(stack.pop().intValue());*/


        while(!stack.isEmpty()) {
            newNode.next = new Node(stack.pop().intValue());
            newNode = newNode.next;
        }

        while(head != null) {
            System.out.print("--> "+head.data);
            head = head.next;
        }

    }


    //using prev, curr and next pointers/refs
    private static void reverseUsingPointers(Node curr) {

        Node prev = null;
        while(curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        Node head = prev;

        while(head != null) {
            System.out.print("--> "+head.data);
            head = head.next;
        }

    }


    //using recursion
    //*** remember draw recursion tree
    //*** termination --> when node ==null || node.next == null
    //*** returns newHead 4-->5 f(4) will get 5, now 5 is front is head.next use front.next = head (5.next = 4)
    //*** break the link head.next = null;

    private static Node reverseOptimal(Node head) {
        if(head == null || head.next == null) {
            return head;
        }

        Node newHead = reverseOptimal(head.next);

        //f(4)-->5

        Node front = head.next;
        front.next = head;
        head.next = null;

        return newHead;
    }

}
