package Lab5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class FindCorrectPassword {
    public static void main(String[] args) {
        if (args.length == 0)
            args = new String[]{"Br0wnF0X", "BrownFoxy", "br0wnfox8", "Br0wn", "FoxThr0tCas1n0CharlieElon"};
        try{
        for (int i = 0; i < args.length; i++) {
            System.out.println(correctPasswordOneRegex(args[i]));
            }
        }catch (PatternSyntaxException e){ System.out.println(e); return;}
    }
    public static boolean correctPasswordOneRegex(String input){
        Pattern PassChecker = Pattern.compile("^(?=.*[0-9])(?=.*[A-Z])(?=\\S+$).{8,16}$");
        Matcher PassMatched = PassChecker.matcher(input);
        return PassMatched.find();
    }

    public static String correctPasswordTFMatcherWay(String input){
        Pattern WordCharacter = Pattern.compile("\\w");
        Pattern digitCheck = Pattern.compile("\\d");
        Pattern upperCheck = Pattern.compile("[A-Z]");
        Matcher a = WordCharacter.matcher(input);
        Matcher b = digitCheck.matcher(input);
        Matcher c = upperCheck.matcher(input);
        while (a.find() && b.find() && c.find() && input.length()>=8 && input.length()<=16)
            return "true";
        return "false";
    }
}
