public class Palindrome {
    public static void main(String[] args) {
        int[] a = {1, 2, 2, 3, 1};
        System.out.println(isPalindrome(a));
        System.out.println(isPalindromeString("madam".toCharArray()));
    }

    private static boolean isPalindrome(int[] array) {
        for (int i = 0, j = array.length - 1; i <= j; i++, j--) {
            if (array[i] != array[j])
                return false;
        }
        return true;
    }

    // TC O(n/2) s
    private static boolean isPalindromeString(char[] c) {
        for (int i = 0, j = c.length - 1; i <= j; i++, j--) {
            if (c[i] != c[j])
                return false;
        }
        return true;

    }
}
