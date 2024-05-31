package striver_sheet.greedy_algos;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinimumNumberOfPlatforms {

    public static void main(String[] args) {

        //*** find minimum no of platforms required for trains arriving and departure at different times...
        //*** Intuition - sort both the arrays even though we loose the track of arr and dep if still know which platform is free or occupied


        List<Double> arr = Arrays.asList(0900d, 0945d, 0955d, 1100d, 1500d, 1800d);
        List<Double> dep = Arrays.asList(0920d, 1200d, 1130d, 1150d, 1900d, 2000d);
        System.out.println(findMin(arr,dep));
        


    }
    
    //two pointer
    private static int findMin(List<Double> arr, List<Double> dep) {
        
        Collections.sort(arr);
        Collections.sort(dep);
        int a = 0;
        int d = 0;
        int max  = 0;
        while(a < arr.size() && d < dep.size()) {
            if(arr.get(a) < dep.get(d)) {
                max = max+1;
                a++;
            } else {
                if(max > 1)
                    max--;
                d++;
            }
        }
        return max;
    }

}
