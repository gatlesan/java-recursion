import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class JavaUtils {

    public static void main(String[] args) {

        int[] array = {2,4,6,7,5};
        //dual pivot quick sort implementation best and avg --> O(n log(n)) worst O(n2)
        Arrays.sort(array);
        Arrays.stream(array).forEach(System.out::print);

        // convert array to List
        List tempList = Arrays.asList(array);
        System.out.println(tempList);


    }
}
