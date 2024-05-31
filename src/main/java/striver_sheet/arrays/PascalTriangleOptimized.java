package striver_sheet.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangleOptimized {


    public static void main(String[] args) {

        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1));
        list.add(Arrays.asList(1,1));
        System.out.println(generate(6, list));
    }

    public static List<List<Integer>> generate(int numRows, List<List<Integer>> p) {

        for(int r=2;r<numRows;r++) {
            List<Integer> pr = p.get(r-1);
            System.out.println(pr);
            List<Integer> newRow = new ArrayList<>();
            //remember the relative index of the element in the row
            for(int c=0;c<=r;c++) {
                if(c ==0 || c == r) {
                    newRow.add(1);
                } else {
                    newRow.add(pr.get(c-1)+pr.get(c));
                }
            }
            p.add(newRow);
        }
        return p;
    }
}
