package TryLab4Catch;

import java.io.*;
import java.nio.file.*;
import static java.nio.file.StandardOpenOption.*;

public class CustomAgeException extends Exception{
    public CustomAgeException(){super();}
    /**
     * {@code CustomAgeException}
    */
    public CustomAgeException(String message) throws IOException {super(message);
        write(message);
    };
    public CustomAgeException(String message, Throwable cause) throws IOException {super(message,cause);
        write(message);}
    public CustomAgeException(Throwable cause) throws IOException {
        super(cause);
        write(String.valueOf(cause));
    }
//
//    public static void ifOccurs(String message){
//        List<String>Error = Arrays.asList("Not possible age triggered", message);
//        Path file = Paths.get("Log.txt");
//        try {
//            Files.write(file, Error , StandardCharsets.UTF_8);
//        } catch (IOException e1){System.out.println("Damnit");}}
    private void write(final String s) throws IOException {
        System.out.println(Path.of(System.getProperty("java.io.tmpdir")));
        Files.writeString(
                Path.of(System.getProperty("java.io.tmpdir"), "filename.txt"),
                s + System.lineSeparator(),
                CREATE, APPEND
        );
    }
}
