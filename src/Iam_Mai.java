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
        System.out.println(numberConverter("five hundred sixty seven"));
        System.out.println(numberConverter("thirty one"));
        System.out.println(numberConverter("one hundred one"));
        System.out.println(maxUniqueRow("123412324"));
        System.out.println(maxUniqueRow("111111"));
        System.out.println(maxUniqueRow("778978898"));
        System.out.println(maxUniqueRow("1234115678"));
        System.out.println(shortCut(new Integer[][]{{1,3,1},{1,5,1},{4,2,1}}));
        System.out.println(shortCut(new Integer[][]{{2,7,3},{1,4,8},{4,5,9}}));
        System.out.println(numericOrder("nin3th an1swer tas4k t2o"));
        System.out.println(numericOrder("t3o the5m 1One all6 r4ule ri2ng"));
        System.out.println(numericOrder("re6sponsibility Wit1h gr5eat power3 4comes g2reat"));
        System.out.println(switchToHighest(159,723));
        System.out.println(switchToHighest(491,3912));
        System.out.println(switchToHighest(6274,71259));
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
        String[] stringNumbers = input.toLowerCase().split(" ");
        int finResult = 0;
        String[] firstNum = new String[]{"zero","one","two","three","four","five","six","seven","eight","nine"};
        String[] smallNum = new String[]{"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] midNum = new String[]{"twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
        for (int i = 0; i < stringNumbers.length; i++) {
            if(stringNumbers[stringNumbers.length-i-1].equals("hundred")){
                i++;
                if(Arrays.stream(firstNum).toList().contains(stringNumbers[stringNumbers.length-i-1]))
                {
                    for (int j = 0; j < firstNum.length; j++) {
                        if(stringNumbers[stringNumbers.length-i-1].equals(firstNum[j]))
                            finResult = finResult + (j)*100;}
                }
            }
            else if(Arrays.stream(firstNum).toList().contains(stringNumbers[stringNumbers.length-i-1]))
            {
                for (int j = 0; j < firstNum.length; j++) {
                    if(stringNumbers[stringNumbers.length-i-1].equals(firstNum[j]))
                        finResult = finResult + (j);}
            }
            else if(Arrays.stream(smallNum).toList().contains(stringNumbers[stringNumbers.length-i-1]))
            {
                for (int j = 0; j < smallNum.length; j++) {
                    if(stringNumbers[stringNumbers.length-i-1].equals(smallNum[j]))
                        finResult = finResult + (j+9);
                }
            }
            else if(Arrays.stream(midNum).toList().contains(stringNumbers[stringNumbers.length-i-1]))
            {
                for (int j = 0; j < midNum.length; j++) {
                    if(stringNumbers[stringNumbers.length-i-1].equals(midNum[j]))
                        finResult = finResult + (j+2)*10;
                }
            }
        }
        return finResult;
    }
    public static String maxUniqueRow(String row){
        char[] chRow = ("" + row).toCharArray();
        String largest = ""; String current = "";
        for (int i = 0; i < chRow.length; i++) {
            if (i == chRow.length-1){
                current = current + chRow[i];
                if (current.length() > largest.length()){largest = current;}
                current = "";
            }
            else if(chRow[i]+1 == chRow[i+1]){
                current = current + chRow[i];
            }
            else {
                current = current + chRow[i];
                if (current.length() > largest.length()){largest = current;}
                current = "";
            }
        }
        return largest;
    }
    //[X1Y1 X1Y2 X1Y3]
    //[X2Y1 X2Y2 X2Y3]
    //[X3Y1 X3Y2 X3Y3]
    public static int shortCut(Integer[][] maze){
        int path = 0; int positionX = 0; int positionY = 0;
        int finXPos = maze.length-1;
        int finYPos = maze[finXPos].length-1;
        int currentCostPath = 0;
        boolean broken = false;
        ArrayList<String> currentPaths = new ArrayList<>();
        String[] possiblePaths = new String[]{""};
        for (int iteration = 0; iteration < finXPos+finYPos; iteration++) {
            if (currentPaths.size() <= 2){currentPaths.add("X");currentPaths.add("Y");}
            else
                currentPaths.clear();
            for (int t = 0; t < possiblePaths.length; t++) {
                currentPaths.add(possiblePaths[t] + "X");
                currentPaths.add(possiblePaths[t] + "Y");
            }
            possiblePaths = currentPaths.toArray(new String[0]);
        }
        for (int iteration = 0; iteration < possiblePaths.length ; iteration++) {
            String[] CurCheck = possiblePaths[iteration].split("");
            currentCostPath = 0;
            positionX = 0;
            positionY = 0;
            broken = false;
            for (int i = 0; i < finXPos+finYPos; i++) {
                currentCostPath += maze[positionX][positionY];
                if (CurCheck[i].equals("X") && positionX != maze.length-1){positionX++;}
                else if (CurCheck[i].equals("Y") && positionY != maze[positionX].length-1){positionY++;}
                else {broken = true;break;}
            }
            if(broken)
                continue;
            currentCostPath += maze[positionX][positionY];
            if(path == 0)
                path = currentCostPath;
            path = (currentCostPath >= path) ? path : currentCostPath;

        }
        return path;
    }
    public static String numericOrder(String sentence){
        String[] wordByWord = sentence.split(" ");
        String[] convert = new String[wordByWord.length];
        for (int i = 0; i < wordByWord.length; i++) {
            String num = wordByWord[i].replaceAll("\\D+","");
            String wrd = wordByWord[i].replaceAll("\\d","");
            convert[i] = num + wrd;
        }
        Arrays.sort(convert);
        for (int i = 0; i < convert.length; i++) {
            convert[i] = convert[i].replaceAll("\\d","");
        }
        return String.join(" ",convert);
    }
    public static int switchToHighest(int x, int y){
        int max = (x>y)? x:y;
        int min = (x<y)? x:y;
        String[] array;
        array = Integer.toString(min).split("");
        Arrays.sort(array);
        for (int i = 0; i < array.length/2; i++) {
            String temp = array[i];
            array[i] = array[array.length-i-1];
            array[array.length-i-1] = temp;
        }
        String[] secArray = Integer.toString(max).split(""); int j = 0;
        for (int i = 0; i < secArray.length-1; i++) {
            if (Integer.parseInt(secArray[i]) < Integer.parseInt(array[j])){ secArray[i] = array[j]; j++;}
        }
        return Integer.parseInt(String.join("",secArray));
    }
}
