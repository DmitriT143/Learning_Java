package Lab5FindAll;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindAllNumbers {
    public static void main(String[] args){
        if (args.length==0){args = new String[]{"This floor costs 25.99 or 16 just f0r y0u"};}
        for (int i = 0; i < args.length; i++) {
            System.out.println(getNumLoseNotNum(args[i]));
            getNumMatcherMethod(args[i]);
        }
    }

    public static String getNumLoseNotNum(String input){
        input = input.replaceAll("\\D","");
        return input;
    }
    public static void getNumMatcherMethod(String text){
        String output = "";
        Pattern p = Pattern.compile("\\d+\\d+");
        Matcher m = p.matcher(text);
        while (m.find()){
            output =  output + m.group() + " ";
        }
        System.out.println(output);
    }
}
