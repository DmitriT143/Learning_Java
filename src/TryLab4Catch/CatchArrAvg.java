package TryLab4Catch;

public class CatchArrAvg {
    public static void main(String[] args) {
        int sum = 0;
        int[] altArray = {1,8,9};
        try{
            for (int i = 0; i < 5; i++) {
                sum = sum + Integer.parseInt(args[i]);
            }
        } catch(NumberFormatException e){System.out.println("Illegal argument");}
        catch (IndexOutOfBoundsException e){sum = 0;try {
            for (int i = 0; i<3; i++){sum = sum+altArray[i];}
        }catch (IndexOutOfBoundsException g){System.out.println("too many errors"); return;}
            System.out.println("we put a placeholder instead: " + sum/(altArray.length)); return;}
        System.out.println(sum/5);
    }
}
