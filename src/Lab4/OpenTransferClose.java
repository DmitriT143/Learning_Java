package Lab4;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
public class OpenTransferClose {
    public static void main(String[] args){
        try {
            String curDir = System.getProperty("user.dir");
            System.out.println(curDir);
            FileReader readBefore = new FileReader(curDir + "\\Meg.txt");
//            FileReader readBefore = new FileReader(curDir + "\\Bob.txt");
            //Force "FileNotFound Error"
            Path printAfter = Path.of(curDir+"\\Bye.txt");
            int i;
            String wasReadFrom = "";
            while((i = readBefore.read()) != -1){
                wasReadFrom = wasReadFrom + Character.toString(i);
            }
            System.out.println(wasReadFrom);
            Files.writeString( printAfter,wasReadFrom);
            readBefore.close();
        } catch (FileNotFoundException e){ System.out.println("Wrong Path");return;}
        catch ( IOException e){ System.out.println("How did you do it?");return;}
    }
}
