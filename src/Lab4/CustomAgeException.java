package Lab4;

import java.io.*;
import java.nio.file.*;
import static java.nio.file.StandardOpenOption.*;

public class CustomAgeException extends Exception{
    public CustomAgeException() throws IOException {super();
        write("Blank message");
    }
    public CustomAgeException(String message) throws IOException {super(message);
        write(message);
    };
    public CustomAgeException(String message, Throwable cause) throws IOException {super(message,cause);
        write(message);}
    public CustomAgeException(Throwable cause) throws IOException {
        super(cause);
        write(String.valueOf(cause));
    }
    private void write(final String s) throws IOException {
        System.out.println(Path.of(System.getProperty("java.io.tmpdir")));
        Files.writeString(
                Path.of(System.getProperty("java.io.tmpdir"), "DemonstrationLog.txt"),
                s + System.lineSeparator(),
                CREATE, APPEND
        );
    }
}
