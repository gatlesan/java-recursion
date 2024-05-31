package striver_sheet.stack_and_queue;

public class QueueUsingArray {
    public static void main(String[] args) {

        //*** understand the concept of circular array and modulo operation
        System.out.println("0%5 = " + 0%5);
        System.out.println("1%5 = " + 1%5);
        System.out.println("2%5 = " + 2%5);
        System.out.println("3%5 = " + 3%5);
        System.out.println("4%5 = " + 4%5);

        //*** understand the concept of modulo operation
        //*** for i where i < n from 0 to n-1 will result in same number
        //*** this concept is used to insert the element to the front of the array - circular array concept.
        System.out.println("5%5 = " + 5%5);



    }
}




//*** Remember the module concept end%5 = 0 when end is at 5th index of the array.
//*** This is used to insert the element to the front of the array - circular array concept.
class Queue {


    private int f = 0;
    private int e = 0;
    private int currSize = 0;
    private int maxSize = 10;
    private  int[] queue = new int[maxSize];

    public void push(int element) {
        if (currSize == maxSize) {
            System.out.println("Queue is full");
            return;
        }
        e = (e + 1) % maxSize;
    }
    //public int pop() {}
    //public int peek() {}




}