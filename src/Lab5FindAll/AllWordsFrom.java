package Lab5FindAll;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AllWordsFrom {

    public static void main(String[] args) {
        wordDivider("The quick brown obsqured fox jumps over the queue of lazy dogs quarrel","q");
        for (int i = 0; i + 1 < args.length;i=i+2)
            wordDivider(args[i],args[i+1]);
    }

    public static void wordDivider(String sentence, String symbol){
        symbol = "([" + symbol + "])";
        Pattern wordsStartingWith = Pattern.compile("(\\s)"+symbol+"(\\w{0,})");
        Matcher allFoundWords = wordsStartingWith.matcher(sentence);
        while (allFoundWords.find())
            System.out.println(allFoundWords.group());
    }
}
