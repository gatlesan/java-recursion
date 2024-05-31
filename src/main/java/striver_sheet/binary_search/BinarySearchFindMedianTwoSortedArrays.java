package striver_sheet.binary_search;

public class BinarySearchFindMedianTwoSortedArrays {

    public static void main(String[] args) {

    }


    // Intuition: Build a smaller left array from 0 to a.length (if a < b)
    // (a > b) return median(b, a) if a is bigger swap the arrays:
    // low =0 , high = a.length
    // mid1 = low + (high - low)/2 // to avoid overflow
    // left = (n1 + n2 + 1) / 2; for odd length get max(l1, l2)
    // mid2 = left - midl
    // l1 ,l2 r1, r2
    // take min and max values if mid goes out of bounds
    // (l1 > r2) high = mid1 - 1;
    // TC: O(log(min(a, b)))
    private static int findMedian(int[] a, int[] b) {
        return 0;
    }
}
