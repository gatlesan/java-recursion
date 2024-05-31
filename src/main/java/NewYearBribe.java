import java.util.Arrays;
import java.util.List;

public class NewYearBribe {

    public static void main(String[] args) {

        // List<Integer> list = Arrays.asList(2,5,1,3,4);
        // List<Integer> list = Arrays.asList(1,2,5,3,4,7,8,6);
        //List<Integer> list = Arrays.asList(5,1,2,3,7,8,6,4);
        List<Integer> list = Arrays.asList(1,2,5,3,7,8,6,4);

        int count = 0;
        boolean too = false;
        for (int i = list.size()-1; i > 0; i--) {
            if (list.get(i) != (i + 1)) {
                if ((i - 1) >= 0 && list.get(i - 1) == (i + 1)) {
                    count = count + 1;
                    swap(i - 1, i, list);
                } else if ((i - 2) >= 0 && list.get(i - 2) == (i + 1)) {
                    count = count + 2;
                    swap(i - 2, i - 1, list);
                    swap(i - 1, i, list);
                } else {
                    System.out.println("Too chaotic");
                    too = true;
                    break;
                }
            }
        }
        if(!too)
            System.out.println(count);
    }

    private static void swap(int i, int j, List<Integer> list) {
        int temp = list.get(i);
        list.set(i,list.get(j));
        list.set(j, temp);
    }

}