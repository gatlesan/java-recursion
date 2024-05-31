package striver_sheet.bst;

public class ConstructBSTFromPreorder {

    public static void main(String[] args) {


        //*** Construct a Binary Search tree from preorder
        //*** Remember if you sort a preorder of a BST you will get the inorder
        //*** if you have inorder and preorder you can construct a BST check BT's

        int[] a = {1, 2, 3};
        globalPointer(a, 0);

        int[] p = {0};
        p[0] = p[0]++;
        System.out.println(p[0]);
        System.out.println(p[0]++);
        System.out.println(p[0]);

        globalPointer(a, new int[]{0});

    }


    // *** understand how to use a global pointer
    private static void globalPointer(int[] a, int p) {

        if (p > a.length - 1) return;
        System.out.println(a[p]);
        globalPointer(a, p + 1);
        globalPointer(a, p + 1);
        return;
    }

    private static void globalPointer(int[] a, int[] p) {

        if (p[0] > a.length - 1) return;
        System.out.println(a[p[0]++]);
        if (p[0] % 2 == 0)
            globalPointer(a, p);
        else
            globalPointer(a, p);
        return;
    }
}
