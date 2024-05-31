package striver_sheet.stack_and_queue;

import java.util.*;
import java.util.Queue;

public class LRU {

    public static void main(String[] args) {

        //*** Stack is a class in java.util package.
        Stack<Integer> stack = new Stack<>();


        // *** PriorityQueue and LinkedList are the Queue implementations in Java.
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.peek());


        // *** Intuition is to keep track of the most recent elements added to the queue.
        // *** Use Doubly Linked List to keep track of the order of elements. Initially create a DLL with head and tail pointing to each other, for every new node check capacity and
        // *** add to the front or else delete the node prev to tail and add to the front
        // *** use HashMap for the elements.

        // *** extended Q'---> implement LFU same as LRU with freq map <int,DDL> and a variable currFreq...

        LRUCache lruCache = new LRUCache(5);
        lruCache.put(1,2);
        lruCache.put(2,3);
        lruCache.put(3,4);
        lruCache.put(4,5);
        lruCache.put(5,6);
        System.out.println(lruCache.get(1));
        lruCache.put(7,7);
        System.out.println(lruCache.get(2));

        lruCache.printAll();

    }


}

class LRUCache {

    private int capacity;
    private DoublyLinkedList doublyLinkedList;

    private Map<Integer, Node> hashMap;

    LRUCache(int capacity) {
        this.capacity = capacity;
        this.doublyLinkedList = new DoublyLinkedList();
        this.hashMap = new HashMap<>();
    }

    public int get(int key) {

        if (this.hashMap.containsKey(key)) {
            this.doublyLinkedList.updateRecent(this.hashMap.get(key));
            return this.hashMap.get(key).value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {

        if (this.hashMap.containsKey(key)) {
            this.doublyLinkedList.updateNode(this.hashMap.get(key));
        } else {
            if (this.capacity == 0) {
                Node deletedNode = this.doublyLinkedList.deleteNode();
                this.hashMap.remove(deletedNode.key);
                this.capacity++;
            }
            Node node = new Node(key, value, null, null);
            Node ref = doublyLinkedList.insertNode(node);
            this.hashMap.put(key, ref);
            this.capacity--;
        }
    }

    public void printAll() {
        System.out.println(this.hashMap);
    }
}

class Node {
    int key;
    int value;
    Node next;
    Node prev;

    Node(int key, int value, Node next, Node prev) {
        this.key = key;
        this.value = value;
        this.next = next;
        this.prev = prev;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}

class DoublyLinkedList {

    private Node head;
    private Node tail;

    public DoublyLinkedList() {

        Node head = new Node(-1, -1, null, null);
        Node tail = new Node(-1, -1, null, null);

        head.next = tail;
        tail.prev = head;

        this.head = head;
        this.tail = tail;
    }

    public Node insertNode(Node ref) {

        Node front = head.next;
        head.next = ref;
        ref.next = front;
        front.prev = ref;
        ref.prev = head;
        return ref;
    }

    public Node deleteNode() {
        Node temp = tail.prev;
        tail.prev = tail.prev.prev;
        tail.prev.next = tail;
        return temp;
    }

    public Node updateNode(Node ref) {
        Node node = head;
        while (node != null) {
            if (node.key == ref.key) {
                node.value = ref.value;
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public Node updateRecent(Node node) {
        Node temp = node;
        node.prev.next = node.next;
        node.next.prev = node.prev;

        //insert in front of head
        Node front = this.head.next;
        front.prev = temp;
        temp.next = front;
        temp.prev = head;
        head.next = temp;

        return temp;
    }
}




