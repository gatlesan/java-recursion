package dp;

import java.util.Date;
import java.util.Map;

public class FrogJumpMinTotEnergy {

    public static void main(String[] args) {

        int[] a = {30, 10, 60, 10, 60, 50};
        int[] mem = new int[a.length];
        long start = System.nanoTime();
        System.out.println(minEnergyTopDown(a.length - 1, a, mem));
        long end = System.nanoTime();
        System.out.println(end-start);


        int[] tab = new int[a.length];
        tab[0] = 0;
        long start1 = System.nanoTime();
        System.out.println(minEnergyTabulation(a,tab));
        long end1 = System.nanoTime();
        System.out.println(end1-start1);

        System.out.println(minEnergyTabulationSpaceOptimized(a));
    }

    private static int minEnergyTopDown(int i, int[] a, int[] mem) {

        if (i == 0) return 0;
        if(mem[i] > 0) {
            return mem[i];
        }

        int left = minEnergyTopDown(i - 1, a, mem) + Math.abs(a[i] - a[i - 1]);
        int right = i > 1 ? minEnergyTopDown(i - 2, a, mem) + Math.abs(a[i] - a[i - 2]) : Integer.MAX_VALUE;
        mem[i] = Math.min(left, right);
        return mem[i];

    }

    private static int minEnergyTabulation(int[] a, int[] tab) {

        for(int i=1; i<a.length; i++) {

            int jump1 = tab[i-1] + Math.abs(a[i] - a[i - 1]);
            int jump2 = i > 1 ? tab[i-2] + Math.abs(a[i] - a[i - 2]) : Integer.MAX_VALUE;
            tab[i] = Math.min(jump1, jump2);

        }
        return tab[a.length-1];
    }

    private static int minEnergyTabulationSpaceOptimized(int[] a) {

        int prev = 0;
        int secondPrev = 0;
        int curr = 0;

        for(int i=1; i<a.length; i++) {

            int jump1 = prev + Math.abs(a[i] - a[i - 1]);
            int jump2 = i > 1 ? secondPrev + Math.abs(a[i] - a[i - 2]) : Integer.MAX_VALUE;
            curr = Math.min(jump1, jump2);
            secondPrev = prev;
            prev = curr;

        }
        return curr;
    }
}
