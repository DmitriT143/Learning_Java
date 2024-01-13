package Lab4;
import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        AgeCheck user = new AgeCheck();
        try {
            user.setAge(16);
//            user.setAge(142);
            //forces exception to age, which is within (0;120)
            System.out.println(user.getAge());
        } catch (CustomAgeException e){System.out.println(e);}
        catch (IOException e) { System.out.println("Null error faced");} // If you get null somhere
        finally {
            System.out.println("Done?");
        }
    }
}
