import java.util.Arrays;

public class ArrayReverse {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        Arrays.stream(array).forEach(System.out::print);
        reverseRecursionOnePointer(array, 0);
        System.out.println();
        System.out.println("----------------------");
        Arrays.stream(array).forEach(System.out::print);
    }

    private static void reverse(int[] array) {

        for (int i = 0, j = array.length - 1; i <= j; i++, j--) {
            swap(array, i, j);
        }
    }

    //reverse recursion
    private static void reverseRecursion(int[] array, int i, int j) {
        if (i >= j)
            return;
        swap(array, i, j);
        //cannot do i++ or j++ as it's a post operations
        reverseRecursion(array, i + 1, j - 1);
    }

    private static void reverseRecursionOnePointer(int[] array, int i) {
        if (i >= array.length - i - 1)
            return;
        swap(array, i, array.length - i - 1);
        //cannot do i++ or j++ as it's a post operations
        reverseRecursionOnePointer(array, i + 1);
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}


