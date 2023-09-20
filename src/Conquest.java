import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Conquest {
    public static void main(String[] args){
        System.out.println("These are answers to Practise work #2");
        System.out.println(duplicatedLetters("Donald"));
        System.out.println(duplicatedLetters("orange"));
        System.out.println(GetInitials("Ryan Gosling"));
        System.out.println(GetInitials("Barack Obama"));
        System.out.println(diffEvenOdd(new int[]{44,32,86,19}));
        System.out.println(diffEvenOdd(new int[]{22,50,16,63,31,55}));
        System.out.println(equalToAverage(new int[]{1,2,3,4,5}));
        System.out.println(equalToAverage(new int[]{1,2,3,4,6}));
        System.out.println(Arrays.toString(indexMultiplier(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(indexMultiplier(new int[]{3, 3, -2, 408, 3, 31})));
        System.out.println(inReverse("Hello World!"));
        System.out.println(inReverse("The quick brown fox."));
        System.out.println(FibonacciForPoor(7));
        System.out.println(FibonacciForPoor(11));
        System.out.println(PseudoHash(5));
        System.out.println(PseudoHash(10));
        System.out.println(PseudoHash(0));
        System.out.println(HelpFinder("Hello, i'm under de water, Help me!"));
        System.out.println(HelpFinder("Hello, I'd like to order um... Cream latte"));
        System.out.println(isAnagram("listen","silent"));
        System.out.println(isAnagram("twelve plus one","eleven plus two"));
        System.out.println(isAnagram("hello","world"));
    }

    public static String duplicatedLetters(String x){
        int i = 0;
        x = x.toLowerCase();
        String[] letters = x.split("");
        while(i < x.length()){
            String currently_checking = letters[i];
            int b = 1;
            while (b < x.length()-i){
               if (currently_checking.equals(letters[i + b])){return "duped";}
               else {b++;}
            }
            i++;
        }
        return "not duped";
    }
    public static String GetInitials(String OC_name){
        String[] distinct = OC_name.split(" ");
        String first_signature = distinct[0];
        String second_signature = distinct[1];
        String[] First_letter_1 = first_signature.split("");
        String[] First_letter_2 = second_signature.split("");
        return First_letter_1[0] + First_letter_2[0];
    }
    public static int diffEvenOdd(int[] x){
        int i = 0;
        int output = 0;
        while (i < x.length) {
            if (x[i]% 2 == 0){output = output + x[i];}
            else{output = output - x[i];}
            i++;
        }
        if (output < 0){output=output*-1;}
        return output;
    }
    public static String equalToAverage(int[] x){
        double sum = 0;
        for (int i = 0; i < x.length;) {
            sum = sum + x[i];
            i++;
        }
        sum = sum/x.length;
        for (int i = 0; i < x.length;) {
            if (x[i]==sum){return "true";}
            i++;
        }
        return "false";
    }
    public static int[] indexMultiplier(int[] x){
        for (int i = 0; i < x.length;) {
            x[i] = x[i] * i;
            i++;
        }
        return x;
    }
    public static String inReverse(String x){
        List<String> reversed = new ArrayList<>() ;
        String[] broken = x.split("");
        for (int i = 0; i < x.length();) {
            reversed.add(broken[x.length()-i-1]);
            i++;
        }
        return String.join("", reversed);
    }
    public static int FibonacciForPoor(int x){
        int j = 0; int a = 0; int b = 0; int c = 1; int timer = x;
        if (x == 0|| x== 1|| x==2){return 0;} else if (x == 3) {return 1;} else {
            for (int i = 3; i < timer;) {
                if (j == 0){ j = 1; a = a+b+c; x = a;}
                else if (j == 1){j = 2; b = a+b+c; x = b;}
                else if (j == 2){ j = 0; c = a+b+c; x = c;}
                i++;
            }
        }
        return x;
    }
    public static String PseudoHash(int len){
        List<String> symbols = Arrays.asList("1","2","3","4","5","6","7","8","9","a","b","c","d","e","f");
        List<String> pseudo_hash = new ArrayList<>();
        int x;
        for (int i = 0; i < len;) {
            x = ThreadLocalRandom.current().nextInt(0,15);
            pseudo_hash.add(symbols.get(x));
            i++;
        }
        return String.join("",pseudo_hash);
    }
    public static String HelpFinder(String input){
        String[] forSearch = input.toLowerCase().split("");
        for (int i = 0; i < input.length()-4;) {
            if(forSearch[i].equals("h")){
                if(forSearch[i+1].equals("e")){
                    if(forSearch[i+2].equals("l")){
                        if(forSearch[i+3].equals("p")){return "Calling for help";}
                    }
                }
            }
            i++;
        }
        return "Keep waiting";
    }
    public static String isAnagram(String original, String failure){
        String[] forDemolition = failure.toLowerCase().replace(" ","").split("");
        String[] forCheck = original.toLowerCase().replace(" ","").split("");
        if(forDemolition.length != forCheck.length){return "false, wrong size";}
        for (int i = 0; i < forCheck.length;) {
            for (int j = 0; j <forDemolition.length;) {
                if(forCheck[i].equals(forDemolition[j])){forDemolition[j]="";}
                j++;
            }
            i++;
        }
        if(String.join("", forDemolition).isEmpty()){return "true";}
        return "false";
    }
}
