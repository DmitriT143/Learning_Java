public class LabPrimeNumber {
    public static void Main(String[] args){
        System.out.println(Primes(100));
    }
    public static int[] Primes(int length){
        int[] count = {0, 1, 2};
        for (int i = 0; i < length; i++) {
            for (int j = 1; j < count.length ;) {
                if (i % count[j] == 0){ count[count.length+1] = i; }
            j++;}
        }
        return count;
    }
}
