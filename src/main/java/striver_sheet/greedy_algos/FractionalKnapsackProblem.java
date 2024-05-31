package striver_sheet.greedy_algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//*** knapsack allow to take fraction of weights
public class FractionalKnapsackProblem {

    public static void main(String[] args) {


        //*** Intuition: sort the item based on val/weight
        //*** pick item as a whole to get the max value as we move if not possible take the fraction

        List<Double> values = Arrays.asList(100d, 60d, 120d, 30d, 200d);
        List<Double> weights = Arrays.asList(20d, 10d, 30d, 10d, 2d);
        int maxWeigth = 50;
        System.out.println(getMaxValitems(values, weights, maxWeigth));


    }

    private static double getMaxValitems(List<Double> values, List<Double> weights, int maxWeigth) {

        List<Item> items = new ArrayList<>();
        for (int i = 0; i < values.size(); i++) {
            Item item = new Item(values.get(i), weights.get(i));
            items.add(item);
        }
        System.out.println(items);
        Collections.sort(items);
        System.out.println(items);
        int maxVal = 0;
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            if (maxWeigth - item.weight > 0) {
                maxVal += item.val;
                maxWeigth -= item.weight;
            } else {
                //take all the remaining max weight
                maxVal += maxWeigth * item.getPerUnitVal();
            }
        }


        return maxVal;
    }
}


class Item implements Comparable<Item> {
    double val;
    double weight;

    Item(double val, double weight) {
        this.val = val;
        this.weight = weight;
    }

    public double getPerUnitVal() {
        return this.val / this.weight;
    }

    @Override
    public int compareTo(Item item) {
        double r1 = (double)(item.val) / (double)(item.weight);
        double r2 = (double)(this.val) / (double)(this.weight);
        if(r1 < r2) return -1;
        else if(r1 > r2) return 1;
        else return 0;
    }

    @Override
    public String toString() {
        return "Item{" +
                "val=" + val +
                ", weight=" + weight +
                '}';
    }
}