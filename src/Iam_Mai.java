import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Iam_Mai {
    public static void main(String[] args) {
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
        System.out.println(alphabeticOrder("klmabzyxw"));
        System.out.println(duplicateToNum("aaabbcdd"));
        System.out.println(duplicateToNum("vvvvaajaaaaa"));
        System.out.println();
    }

    public static String nonRepeatable(String s) {
        int i = s.length();
        if (i <= 1) {
            return s;
        }
        if (Arrays.stream(s.substring(0, i - 1).split("")).toList().contains(s.substring(i - 1, i))) {
            return nonRepeatable(s.substring(0, i - 1));
        } else return nonRepeatable(s.substring(0, i - 1)) + s.charAt(i - 1);
    }
//Todo: Rework bracket generator to recursion
    public static String generateBrackets(int len) {
        ArrayList<String> CurrentAttempt;
        String[] PreviousAttempt = new String[]{""};
        for (int i = 0; i < len; i++) {
            CurrentAttempt = new ArrayList<>();
            for (int j = 0; j < PreviousAttempt.length; j++) {
                if (!CurrentAttempt.contains("(" + PreviousAttempt[j] + ")")) {
                    CurrentAttempt.add("(" + PreviousAttempt[j] + ")");
                }
                if (!CurrentAttempt.contains(PreviousAttempt[j] + "()")) {
                    CurrentAttempt.add(PreviousAttempt[j] + "()");
                }
                if (!CurrentAttempt.contains("()" + PreviousAttempt[j])) {
                    CurrentAttempt.add("()" + PreviousAttempt[j]);
                }
            }
            PreviousAttempt = CurrentAttempt.toArray(new String[0]);
        }
        return String.join(",", PreviousAttempt);
    }

    public static String binarySystem(Integer len) {
        ArrayList<String> binaryCurrent;
        String[] binaryPrevious = new String[]{""};
        for (int i = 0; i < len; i++) {
            binaryCurrent = new ArrayList<>();
            for (int j = 0; j < binaryPrevious.length; j++) {
                if (!binaryCurrent.contains("0" + binaryPrevious[j])) {
                    binaryCurrent.add("0" + binaryPrevious[j]);
                }
                if (!binaryCurrent.contains("1" + binaryPrevious[j])) {
                    binaryCurrent.add("1" + binaryPrevious[j]);
                }
            }
            binaryPrevious = binaryCurrent.toArray(new String[0]);
        }
        if (binaryPrevious.length > 0) {
            binaryCurrent = new ArrayList<>();
            for (int i = 0; i < binaryPrevious.length; i++) {
                String[] check = binaryPrevious[i].split("");
                boolean in_array = true;
                for (int j = 0; j < len - 1; j++) {
                    if (check[j].equals("0") && check[j + 1].equals("0")) {
                        in_array = false;
                        break;
                    }
                }
                if (in_array) {
                    binaryCurrent.add(binaryPrevious[i]);
                }
            }
            binaryPrevious = binaryCurrent.toArray(new String[0]);
        }
        return String.join(",", binaryPrevious);
    }
//Todo: Fix this BS with alphabetic order till next mon.
    public static String alphabeticOrder(String input) {
        String[] alphabet = "abcdefghijklmnopqrstuvwxyz ".split("");
        String[] inRow = input.toLowerCase().replace(" ", "").split("");
        ArrayList<String> currentRow = new ArrayList<String>();
        String[] biggestRow = new String[]{"a"};
        for (int i = 0; i < inRow.length; i++) {
            for (int j = 0; j < alphabet.length; j++) {
                if (inRow[i].equals(alphabet[j])) {
                    if (inRow.length >= i + 2 && inRow[i + 1].equals(alphabet[j + 1])) {
                        currentRow = new ArrayList<String>();
                        currentRow.add(inRow[i]);
                        while (i+2 <= inRow.length && inRow[i + 1].equals(alphabet[j + 1])) {
                            i++;
                            j++;
                            currentRow.add(inRow[i]);
                        }
                    }
                    else if (inRow.length >= i + 2 && inRow[i + 1].equals(alphabet[j - 1])) {
                        currentRow = new ArrayList<String>();
                        currentRow.add(inRow[i]);
                        while (i+2 <= inRow.length && inRow[i + 1].equals(alphabet[j - 1])) {
                            currentRow.add(inRow[i]);
                            i++;
                            j++;
                        }
                    }
                    if (biggestRow.length <= currentRow.size()){biggestRow = currentRow.toString().split("");}
                    break;
                }
            }

        }
        return String.join("", biggestRow);
    }
    public static String duplicateToNum(String origin){
        int mat_len = 1; String output = "";
        String[] splitTed = origin.split("");
        for (int i = 0; i < origin.length()-1; i++) {
            if(!splitTed[i].equals(splitTed[i+1])){mat_len++;}
        }
        String[][] Symbols_matrix = new String[mat_len][1];
        for (int i = 0; i < mat_len; i++) {
            Symbols_matrix[i][0] = "";
        }
        for (int i = 0, j = 0; i < origin.length(); i++)
        {
            if(i == origin.length()-1){Symbols_matrix[j][0] = Symbols_matrix[j][0] + splitTed[i]; break;}
            if (splitTed[i].equals(splitTed[i+1])){
                Symbols_matrix[j][0] = Symbols_matrix[j][0] + splitTed[i];
            } else {Symbols_matrix[j][0] = Symbols_matrix[j][0] + splitTed[i];j++;}
        }
        for (int i = 0; i < mat_len; i++){
            output = output + Symbols_matrix[i][0].split("")[0] + Symbols_matrix[i][0].split("").length;
        }
        origin = Arrays.deepToString(Symbols_matrix);
    return origin;
    }
    public static int numberConverter(String input){
        String[] stringNumbers = input.split(" ");
        int finResult = 0; int interResult;
        String[] firstNum = new String[]{"zero","one","two","three","four","five","six","seven","eight","nine"};
        String[] smallNum = new String[]{"", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        return 0;
    }
}
