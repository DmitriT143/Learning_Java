package Lab1;

import java.util.ArrayList;
public class LabPrimeNumber {
    public static void main(String[] args){
        for (int i = 0; i < args.length; i++) {
            int s = Integer.parseInt(args[i]);
            System.out.println(isPrime(s));}
        System.out.println(Primes(100));}
    public static String Primes(int length){
        ArrayList<Integer> count = new ArrayList<>();
        count.add(1);
        boolean isPrime;
        for(int i = 2; i < length;){
            isPrime = true;
            for (int j = 1; j < count.size(); j++) {if (i % count.get(j) == 0){isPrime = false;}}
            if (isPrime){ count.add(i);}
            i++;}
        return count.toString();
    }
    public static Boolean isPrime(int n){
        ArrayList<Integer> count = new ArrayList<>();
        count.add(1);
        boolean isPrime;
        for(int i = 2; i < 100;) {
            isPrime = true;
            for (int j = 1; j < count.size(); j++) {
                if (i % count.get(j) == 0) {
                    isPrime = false;
                }
            }
            if (isPrime) {
                count.add(i);
            }
            i++;
        }
        for (int i = 1; i < count.size(); i++) {
            if (n == count.get(i)){return true;}
            if (n % count.get(i) == 0){return false;}
        }
        return true;
    }
}
