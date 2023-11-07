package TryLab4Catch;
import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        AgeCheck user = new AgeCheck();
        try {
            user.setAge(-5);
        } catch (CustomAgeException e){System.out.println(e);} catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
