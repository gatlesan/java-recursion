package striver_sheet.trees;

public class MorrisInorder {

    // *** optimization from O(n) space to O(1)
    // *** Threaded Binary Tree
    // *** After last node of any subtree you go back to the parent
    // *** Intuition - To not use any stack space - we need a way to go back to the parent, and we can do this if last node of the left subtree points to curr

    // 1. if left is null print curr and move right
    // 2. find right most on left subtree and point to self - here print curr for preorder
    // 3. when on curr node -  if thread already exists remove the link and go right - here print curr for inorder traversal
    public static void main(String[] args) {


    }
}
