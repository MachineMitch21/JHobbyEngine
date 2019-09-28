package JHobbyEngine.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileUtilities {
    public static String readFile(String file, boolean keepNewLines) throws IOException {
        String data = "";

        BufferedReader reader = new BufferedReader(new FileReader(file));

        String line = "";
        while ((line = reader.readLine()) != null) {
            data = data.concat((keepNewLines ? line.concat("\n") : line));
        }

        return data;
    }
}
