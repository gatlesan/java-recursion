import java.math.BigInteger;

public class RecursiveDigitSum {

    public static void main(String[] args) {
        String n = "148";
        int k = 2;
        StringBuilder s = new StringBuilder();
        s.append(n.repeat(k));
        int res = add(s);
        System.out.println(res);

    }

    private static int add(StringBuilder s) {

        if (s.length() == 1) {
            return s.charAt(0) - '0';
        }
        BigInteger res = BigInteger.valueOf(0);
        for (int i = 0; i < s.length(); i++) {
            res = res.add(BigInteger.valueOf(s.charAt(i) - '0'));
        }
        return add(new StringBuilder(res.toString()));
    }
}
