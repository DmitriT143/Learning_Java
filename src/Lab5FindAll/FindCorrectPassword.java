package Lab5FindAll;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindCorrectPassword {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            try {
            System.out.println(correctPasswordTFMatcherWay(args[i]));
            }catch (Exception e){ System.out.println(e); return;}
        }
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
