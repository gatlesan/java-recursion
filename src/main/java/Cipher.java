public class Cipher {

    public static void main(String[] args) {
        System.out.println(Character.codePointAt("A".toCharArray(), 0));
        char c = (char) (Character.codePointAt("s".toCharArray(), 0)+3);
        System.out.println(c);
        System.out.println(Character.isLetter('-'));


        // 97 + (cp - 97 + k) % 26
        System.out.println(97+(97-97+2)%26);

    }
}
