package simple_tips;

import java.io.ObjectStreamException;

public class Tips {

    public static void main(String[] args) {

/*        int top = -1;
        int[] container = new int[10];

        Container c = new Container(10);
        c.add(1);
        c.add(2);
        c.printAllItems();
        c.remove();
        c.printAllItems();*/

        System.out.println(Math.sqrt(25));

        System.out.println(Character.codePointAt(new char[]{'a'}, 0));

    }
}


class Container {

    private static Object[] container;
    private static int curr;

    Container(int cap) {
        container = new Object[cap];
        curr = -1;
    }

    public static void printAllItems() {
        for (Object item : container) {
            if (item != null)
                System.out.println(item);
        }
    }

    public static void add(Object item) {
        curr++;
        container[curr] = item;
    }

    public static Object remove() {
        if (curr > -1) {
            Object item = container[curr--];
            container[curr] = null;
            return item;
        } else
            return null;

    }
}