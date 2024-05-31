import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Regex {
    public static void main(String[] args) {
        String t = "t.*y";
        String d = "1988-02-1*";
        String[] dateVal = {"1988-02-10", "1989-02-01", "1970-02-01"};
        Pattern pattern = null;
        try {
            pattern = Pattern.compile(t);
        } catch (PatternSyntaxException patternSyntaxException) {
            System.out.println("Invalid pattern given");
            patternSyntaxException.printStackTrace();
        }
        String[] values = {"tom","tinny","bunny","place inn"};
        for(String value : values) {
            Matcher matcher = pattern.matcher(value);
            if (matcher.matches()) {
                System.out.println("Matched "+value);
            }
        }
    }
}
