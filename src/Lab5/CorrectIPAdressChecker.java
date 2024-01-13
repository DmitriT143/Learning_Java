package Lab5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class CorrectIPAdressChecker {
    public static void main(String[] args) {
        try {
        if (args.length<=0)
            args = new String[]{"192.168.1.1"};
        for (int i = 0; i < args.length; i++) {
            System.out.println(compiler(args[i]));
        }
        }catch (PatternSyntaxException e){System.out.println(e); return;}
    }
    public static boolean compiler(String input){
        Pattern IPPattern = Pattern.compile("(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)");
        Matcher IPMatcher = IPPattern.matcher(input);
        return IPMatcher.find();
    }
}
