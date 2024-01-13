package Lab4;

public class CatchArrAvg {
    public static void main(String[] args) {
        if (args.length == 0){
        //args = new String[]{"1","2","3","4","5"};
//        args = new String[]{"1","2","3","no","5"};
        // Catches out of bound exception
//        args = new String[]{"1","2","3","5"};
        //Catches NumberFormatException
        }
        int sum = 0;
        try{
            for (int i = 0; i < 5; i++) {
                sum = sum + Integer.parseInt(args[i]);
            }
            System.out.println(sum/5);
        } catch(NumberFormatException e){System.out.println("Illegal argument"); return;}
        catch (IndexOutOfBoundsException e){System.out.println("Illegal range"); return;}
    }
}
