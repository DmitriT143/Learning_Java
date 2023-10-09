import java.util.ArrayList;
import java.util.Arrays;

public class Conquer_two {
    public static void main(String[] args) {
        System.out.println("Answers to third practise work");
        System.out.println("Task 1");
        System.out.println(replaceVowels("Even if you did the task not by yourself, you have to understand every line of code"));
        System.out.println(replaceVowels("apple"));
        System.out.println("Task 2");
        System.out.println(doublingSeason("hello"));
        System.out.println(doublingSeason("beekeeper and bookkeeper with iing season"));
        System.out.println("Task 3");
        System.out.println(doesItFit(1,3,5,4,5));
        System.out.println(doesItFit(1,8,1,1,1));
        System.out.println(doesItFit(1,2,2,1,1));
        System.out.println("Task 4");
        System.out.println(numCheck(243));
        System.out.println(numCheck(52));
        System.out.println("Task 5");
        System.out.println(countRoots(new int[]{1,-3,2}));
        System.out.println(countRoots(new int[]{2,5,2}));
        System.out.println(countRoots(new int[]{1,-6,9}));
        System.out.println("Task 6");
        System.out.println(salesData(new String[][]{{"Apple", "Shop1", "Shop2", "Shop3", "Shop4"},{"Banana", "Shop2", "Shop3", "Shop4"},{"Orange", "Shop1", "Shop3", "Shop4"},{"Pear", "Shop2", "Shop4"}}));
        System.out.println(salesData(new String[][]{{"Fridge", "Shop2", "Shop3"},{"Microwave", "Shop1", "Shop2", "Shop3", "Shop4"},{"Laptop", "Shop3", "Shop4"},{"Phone", "Shop1", "Shop2", "Shop3", "Shop4"}}));
        System.out.println("Task 7");
        System.out.println(validSplit("apple eagle egg goat"));
        System.out.println(validSplit("cat dog goose fish"));
        System.out.println("Task 8");
        System.out.println(waveFormCheck(new int[]{3, 1, 4, 2, 7, 5}));
        System.out.println(waveFormCheck(new int[]{1, 2, 3, 4, 5}));
        System.out.println(waveFormCheck(new int[]{1, 2, -6, 10, 3}));
        System.out.println("Task 9");
        System.out.println(commonVowel("Hello world"));
        System.out.println(commonVowel("Actions speak louder than words."));
        System.out.println("Task 10");
        System.out.println(Arrays.deepToString(dataScience(new Integer[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 29, 10}, {5, 5, 5, 5, 35}, {7, 4, 3, 14, 2}, {1, 0, 11, 10, 1}})));
        System.out.println(Arrays.deepToString(dataScience(new Integer[][]{{6, 4, 19, 0, 0}, {81, 25, 3, 1, 17}, {48, 12, 60, 32, 14}, {91, 47, 16, 65, 217}, {5, 73, 0, 4, 21}})));
    }
    public static String replaceVowels(String input){
        String[] vowels = new String[]{"a","e","y","i","o","u"};
        for (int i = 0; i < vowels.length;) {
            input = input.toLowerCase().replace(vowels[i], "*");
            i++;
        }
        return input;
    }
    public static String doublingSeason (String text){
        String[] checkedText = text.split("");
        for (int i = 0; i < checkedText.length-1;) {
            if(checkedText[i].equals(checkedText[i + 1])) {
                    checkedText[i] = "Double";
                    checkedText[i + 1] = checkedText[i + 1].toUpperCase();
                }
        i++;}
        return String.join("", checkedText);
    }
    public static boolean DoesItFit_mistook(int a,int b,int c,int x,int y){
        int[] toy = new int[]{a,b,c};
        int biggest = x>=y? x:y;
        int smallest = x<=y? x:y;
        for (int i = 0; i < 3;){
            if (toy[i]<=smallest){toy[i] = biggest+1; for(int j = 0; j < 3;){if (toy[j]<=biggest){return true;}j++;}}
            i++;
        }
        return false;
    }
    // без циклов, но с работой с контейнером
    public static boolean doesItFit(int a, int b,int c,int x,int y){
        int[] toy = new int[]{a,b,c};
        int[] hole = new int[]{x,y};
        Arrays.sort(toy);
        Arrays.sort(hole);
        return (toy[0] <= hole[0] && toy[1] <= hole[1]);
    }
    public static boolean numCheck(int input){
        int num = 0;
        int extra_num = input;
        while (extra_num > 0){
            num = (extra_num % 10)^2 + num ;
            extra_num = extra_num/10;
        }
        return  (input% 2 == num% 2);
    }
    public static int countRoots (int[] x){
        int a = x[0]; int b = x[1]; int c = x[2];
        int d = b*b - (4 * a * c);
        if (d == 0){if (b/a % 2 == 0){return 1;}
            return 0;
        }
        else if (d > 0) {
            double L = (Math.sqrt(d) - b)/(2*a);
            double R = (-Math.sqrt(d) - b)/(2*a);
            if(R%1 == 0&& L%1 == 0){ return 2;}
            else if (R%1 ==0 || L%1 ==0){return 1;}
            else {return 0;}
        }
        else {return 0;}
    }
    public static String salesData(String[][] input){
        int shops = 0; int not_loose = 0;
        ArrayList<String> shopItems = new ArrayList<>();
        for (int i = 0; i < input.length;) {
            if (input.length > shops){shops = input[i].length;}
            i++;}
        for (int i = 0; i < input.length;) {
            if (input[i].length == shops){shopItems.add(input[i][0]); not_loose = 1;}
        i++;}
        if (not_loose == 1) {
            return shopItems.toString();
        }
        return "no multiple sales found";
    }
    public static boolean validSplit(String input){
        String[] wordByWord = input.split(" ");
        for (int i = 1; i < wordByWord.length; i++) {
            if (!wordByWord[i].split("")[0].equals(wordByWord[i-1].split("")[wordByWord[i-1].length()-1])){return false;}
        }
        return true;
    }
    public static boolean waveFormCheck (int[] input){
        boolean Up;
        if (input[0] > input[1]){Up = true;}
        else {Up = false;}
        for (int i = 1; i < input.length-1; i++) {
            if (Up && input[i] < input[i+1]){Up = false;}
            else if (!Up && input[i] > input[i+1]){Up = true;}
            else return false;
        }
        return true;
    }
    public static String commonVowel(String sentence) {
        String MaxOccurring = "";
        int MaxOccurred = 0;
        String Vowels = "aeioyu";
        String[] assorted = sentence.toLowerCase().replace(" ","").split("");
        for (int i = 0; i < assorted.length; i++) {
            if (Vowels.contains(assorted[i])) {
                String currentlySorting = assorted[i];
                int Occurrences = 1;
                for (int j = 0; j < assorted.length; j++) {
                    if (currentlySorting.equals(assorted[j])) {
                        Occurrences++;
                    }
                }
                if (Occurrences > MaxOccurred) {
                    MaxOccurred = Occurrences;
                    MaxOccurring = currentlySorting;
                };
            }
        }
        return MaxOccurring;
    }
    public static Integer[][] dataScience(Integer[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            int changeTo = 0;
            for (int j = 0; j < matrix.length; j++) {
                if(j!=i){changeTo = changeTo+matrix[j][i];}
            }
            matrix[i][i] = changeTo/4;
        }
        return matrix;
    }
}
