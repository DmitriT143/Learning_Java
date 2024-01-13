package Lab1;

public class labIsPalindrome {
    public static void main(String[] args){
        for (int i = 0; i < args.length; i++) {
            String s = args[i];
            System.out.println(isWordPalindrome(s));
        }
    }
    public static Boolean isWordPalindrome(String c){
        char[] input = c.toCharArray();
        int l = input.length -1;
        for (int i = 0; i < l;) {
            if (input[i] != input[l]) {return false;}
        i++; l--;}
        return true;
    }
}
