public class StringsDemo {
    public static void main(String[] args) {

        String s = "lirilb";
        for(int i=0;i<s.length();i++) {
            char[] c = new char[s.length()-1];
            int k = 0;
            for(int j=0;j<s.length();j++) {
                if(j != i) {
                    c[k] = s.charAt(j);
                    k++;
                }
            }
            System.out.println(new String(c));
            System.out.println(isPalindrome(new String(c)));

            //code point
            System.out.println(s.codePointAt(i));

            s.replace("s","c");
            s.charAt(0);
        }

    }

    private static boolean isPalindrome(String s) {
        int p1 = 0;
        int p2 = s.length() - 1;
        boolean f = false;

        for (; p1 < p2; ) {
            if (s.charAt(p1) == s.charAt(p2))
                f = true;
            else
                return false;
            p1++;
            p2--;
        }
        return f;
    }
}
