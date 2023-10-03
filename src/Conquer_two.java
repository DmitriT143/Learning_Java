import java.util.ArrayList;

public class Conquer_two {
    public static void main(String[] args) {
        System.out.println("Answers to third practise work");
        System.out.println(replaceVowels("Even if you did the task not by yourself, you have to understand every line of code"));
        System.out.println(replaceVowels("apple"));
        System.out.println(doublingSeason("hello"));
        System.out.println(doublingSeason("beekeeper and bookkeeper with iing season"));
        System.out.println(doesItFit(1,3,5,4,5));
        System.out.println(doesItFit(1,8,1,1,1));
        System.out.println(doesItFit(1,2,2,1,1));
        System.out.println(numCheck(243));
        System.out.println(numCheck(52));
        System.out.println(countRoots(new int[]{1,-3,2}));
        System.out.println(countRoots(new int[]{2,5,2}));
        System.out.println(countRoots(new int[]{1,-6,9}));
        System.out.println(salesData(new String[]{"Apple", "Shop1", "Shop2", "Shop3", "Shop4"},
                new String[]{"Banana", "Shop2", "Shop3", "Shop4"},
                new String[]{"Orange", "Shop1", "Shop3", "Shop4"},
                new String[]{"Pear", "Shop2", "Shop4"}));
        System.out.println(salesData(new String[]{"Fridge", "Shop2", "Shop3"},
                new String[]{"Microwave", "Shop1", "Shop2", "Shop3", "Shop4"},
                new String[]{"Laptop", "Shop3", "Shop4",},
                new String[]{"Phone", "Shop1", "Shop2", "Shop3", "Shop4"}));
        System.out.println();
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
    public static String doesItFit(int a,int b,int c,int x,int y){
        int[] toy = new int[]{a,b,c};
        int biggest = x>=y? x:y;
        int smallest = x<=y? x:y;
        for (int i = 0; i < 3;){
            if (toy[i]<=smallest){toy[i] = biggest+1; for(int j = 0; j < 3;){if (toy[j]<=biggest){return "It does fit";}j++;}}
            i++;
        }
        return "it doesn't";
    }
    public static String numCheck(int input){
        int num = 0;
        int extra_num = input;
        while (extra_num > 0){
            num = (extra_num % 10)^2 + num ;
            extra_num = extra_num/10;
        }
        if (input% 2 == num% 2){return "true";}
        return "false";
    }
    public static int countRoots (int[] x){
        int a = x[0]; int b = x[1]; int c = x[2];
        int d = a^2 - 4 * b * c;
        if (d == 0){return d;} else if (d > 0) { return d;} else {return 0;}
    }
    public static String salesData(String[] array0,String[] array1,String[] array2,String[] array3){
        String[][] input = {array0 ,array1, array2, array3};
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
}
