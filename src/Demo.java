public class Demo {
    public static void main(String[] args) {
        System.out.println("This is answer to first Task:");
        System.out.println(convertor(5));
        System.out.println(convertor(3));
        System.out.println(convertor(8));
        System.out.println("This is answer to Second Task:");
        System.out.println(FitCalc(15,1));
        System.out.println(FitCalc(24,2));
        System.out.println(FitCalc(41,3));
        System.out.println("This is answer to Third Task:");
       System.out.println(containers(3,4,2));
        System.out.println(containers(5,0,2));
        System.out.println(containers(4,1,4));
        System.out.println("This is answer to Fourth Task:");
        System.out.println(triangle_Type(5,5,5));
        System.out.println(triangle_Type(5,4,5));
        System.out.println(triangle_Type(3,4,5));
        System.out.println(triangle_Type(1,1,5));
        System.out.println("This is answer to Fifth Task:");
        System.out.println(ternaryEvaluation(8,4));
        System.out.println(ternaryEvaluation(1,11));
        System.out.println(ternaryEvaluation(5,9));
        System.out.println("This is answer to Sixth Task:");
        System.out.println(howManyItems(22, 1.4 , 2));
        System.out.println(howManyItems(45, 1.8 , 1.9));
        System.out.println(howManyItems(100, 2 , 2));
        System.out.println("This is answer to Seventh Task:");
        System.out.println(factorial(3));
        System.out.println(factorial(5));
        System.out.println(factorial(7));
        System.out.println("This is answer to Eighth Task:");
        System.out.println(gcd(48,18));
        System.out.println(gcd(52,8));
        System.out.println(gcd(259,28));
        System.out.println("This is answer to Ninth Task:");
        System.out.println(ticketsaler(70, 1500));
        System.out.println(ticketsaler(24, 950));
        System.out.println(ticketsaler(53, 1250));
        System.out.println("This is answer to Tenth Task:");
        System.out.println(tables(5, 2));
        System.out.println(tables(31, 20));
        System.out.println(tables(123, 58));
    }
    public static double convertor(int x){
        return x*3.785;
    }
    public static int FitCalc(int x, int y) {
        if (y == 1) {
            return x;
        } else if (y == 2) {
            return x * 2;
        } else if (y == 3) {
            return x * 3;
        } else {
            return x;
        }
    }
    public static int containers(int crate, int bag, int barrel){
        return crate * 20 + bag * 50 + barrel * 100;
    }
    public static String triangle_Type(int x, int y, int z){
        if (x + y < z || x + z < y || z + y < x){
            return "Not Triangle";
        } else if (x == y && x == z){
            return "Isosceles Triangle";
        } else if ( x == y && x != z|| x == z && x != y) {
            return "Equilateral triangle";
        } else if (x != y && x != z) {
            return "Different sided triangle";
        } else {
            return "Something went wrong";
        }
    }
    public static int ternaryEvaluation(int x, int y){
        return (x >= y)? x : y;
    }
    public  static  int howManyItems(double x, double w, double h){
        return (int) (x/ 2 / w / h);
    }
    public static int factorial(int input){
        int output = 1;
        int i = 1;
        while (true){
            if (input < i) break;
            output = output * i;
            i += 1;
        }
        return output;
    }
    public static int gcd(int a, int b){
        int lowest;
        int output = 1;
        int i = 1;
        lowest = (b >= a)? a : b;
         while (true){
             if (i >= lowest) break;
             if (a%i == b%i & a%i == 0 & b%i == 0){
                 output = i;
             }
             i+= 1;
         }
         return output;
    }
    public static double ticketsaler(int x, double y){return y = x * y * 0.72;}
    public static double tables(double x, double y){
        double stud_inter = (x / 2 - y) * 2;
        if (stud_inter < 0){stud_inter = 0;}
        return stud_inter;
    }
}