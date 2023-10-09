import java.awt.*;
import java.util.ArrayList;

public class Iam_Mai {
    public static void main (String[] args){
        System.out.println("Answers to fourth practise work");
        System.out.println(nonRepeatable("abracadabra"));
        System.out.println(nonRepeatable("paparazzi"));
        System.out.println(generateBrackets(1));
        System.out.println(generateBrackets(2));
        System.out.println(generateBrackets(3));
        System.out.println(binarySystem(2));
        System.out.println(binarySystem(3));
        System.out.println(binarySystem(4));
        System.out.println(alphabeticOrder("abcdjuwx"));
        System.out.println();
    }
    public static String nonRepeatable(String sentence){
        String[] letterByLetter = sentence.toLowerCase().split("");
        ArrayList<String> repeated = new ArrayList<>();
        for (int i = 0; i < letterByLetter.length; i++) {
            if (!repeated.contains(letterByLetter[i])) {
                repeated.add(letterByLetter[i]);
            }
        }
        return String.join("",repeated);
    }
    public static String generateBrackets(int len){
        ArrayList<String> CurrentAttempt;
        String[] PreviousAttempt = new String[]{""};
        for (int i = 0; i <len; i++) {
            CurrentAttempt = new ArrayList<>();
            for (int j = 0; j < PreviousAttempt.length; j++) {
                if(!CurrentAttempt.contains("(" + PreviousAttempt[j] + ")")){CurrentAttempt.add("(" + PreviousAttempt[j] + ")");}
                if(!CurrentAttempt.contains(PreviousAttempt[j] + "()")){CurrentAttempt.add(PreviousAttempt[j] + "()");}
                if(!CurrentAttempt.contains("()" + PreviousAttempt[j])){CurrentAttempt.add("()" + PreviousAttempt[j]);}
            }
            PreviousAttempt = CurrentAttempt.toArray(new String[0]);
        }
        return String.join(",",PreviousAttempt);
    }
    public static String binarySystem (Integer len){
        ArrayList<String> binaryCurrent;
        String[] binaryPrevious = new String[]{""};
        for (int i = 0; i < len; i++) {
            binaryCurrent = new ArrayList<>();
            for (int j = 0; j <binaryPrevious.length ; j++) {
                if(!binaryCurrent.contains("0" + binaryPrevious[j])){binaryCurrent.add("0" + binaryPrevious[j]);}
                if(!binaryCurrent.contains("1" + binaryPrevious[j])){binaryCurrent.add("1" + binaryPrevious[j]);}
            }
            binaryPrevious = binaryCurrent.toArray(new String[0]);
        }
        if (binaryPrevious.length >0){
            binaryCurrent = new ArrayList<>();
            for (int i = 0; i < binaryPrevious.length; i++) {
                String[] check = binaryPrevious[i].split("");
                boolean in_array = true;
                for (int j = 0; j < len - 1; j++) {
                    if (check[j].equals("0") && check[j+1].equals("0")){ in_array = false; break;}
                }
                if (in_array){binaryCurrent.add(binaryPrevious[i]);}
            }
            binaryPrevious = binaryCurrent.toArray(new String[0]);
        }
        return String.join(",",binaryPrevious);
    }
    public static String alphabeticOrder (String input){
        String[] alphabet = "abcedfghijklmnopqrstuvwxyz".split("");
        ArrayList<Character> biggestRow;
        String[] inRow = input.toLowerCase().replace(" ","").split("");
        for (int i = 0; i < inRow.length; i++) {
            for (int j = 0; j < alphabet.length; j++) {
                if (inRow[i].equals(alphabet[j])){
                    if (inRow[i+1].equals(alphabet[i+1])){boolean rowGoesUp = true; break;}
                    else if (inRow[i+1].equals(alphabet[i-1])){boolean rowGoesUp = false; break;}
                    else {break;}
                }
            }
        }
        return String.join("",inRow);
    }
}
