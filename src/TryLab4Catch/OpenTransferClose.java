package TryLab4Catch;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class OpenTransferClose {

    public static void main(String[] args){
        try {
            FileReader readBefore = new FileReader("S:\\Misс\\JavaProjects\\Learning_Java_0\\src\\TryLab4Catch\\Hello.txt");
            Path printAfter = Path.of("S:\\Misс\\JavaProjects\\Learning_Java_0\\src\\TryLab4Catch\\Bye.txt");
            int i;
            String wasReadFrom = "";
            while((i = readBefore.read()) != -1){
                wasReadFrom = wasReadFrom + Character.toString(i);
            }
            System.out.println(wasReadFrom);
            Files.writeString( printAfter,wasReadFrom);
            readBefore.close();
        } catch (FileNotFoundException e){ System.out.println("Wrong Path");return;}
        catch (RuntimeException e){ System.out.println("Wrong way to copy");return;}
        catch ( IOException e){ System.out.println("How did you do it?");return;}
    }
}
