package Lab5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class AllWordsFrom {

    public static void main(String[] args) {
        try {
            wordDivider("The quick brown obsqured fox jumps over the queue of lazy dogs quarrel", "qui");
            for (int i = 0; i + 1 < args.length; i = i + 2)
                wordDivider(args[i], args[i + 1]);
        } catch (PatternSyntaxException e){ System.out.println(e); return;}
    }

    public static void wordDivider(String sentence, String symbol){
        Pattern wordsStartingWith = Pattern.compile("(\\b)"+symbol+"(\\w{0,})");
        Matcher allFoundWords = wordsStartingWith.matcher(sentence);
        while (allFoundWords.find())
            System.out.println(allFoundWords.group());
    }
}
