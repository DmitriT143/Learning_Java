package Lab6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class MostUsed {
    public static void main(String[] args) throws IOException {
        TopFromFile("beemovie.txt");
    }

    public static void TopFromFile(String input) throws IOException {
        Path path = Path.of(System.getProperty("user.dir") +"\\src\\Lab6ReadAndRepeat\\" + input);
        String readAndScan = Files.readString(path);
        Map<String,Integer> wordsLib = new HashMap<>();
        String[] words = readAndScan.split("\\W{1,}");
        for (String word : words){
            Integer prevCount = wordsLib.get(word);
            if (prevCount == null){prevCount = 0;}
            wordsLib.put(word,prevCount+1);
        }
        ArrayList<Map.Entry<String, Integer>> allWords = new ArrayList<>(wordsLib.entrySet());
        allWords.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() > o2.getValue())
                    return 1;
                else if (o1.getValue() == o2.getValue()) {
                    return 0;
                } else return -1;
            }
        });
        for (int i = 1; i < 10; i++) {
            System.out.println(allWords.get(allWords.size()-i));
        }
    }
}
