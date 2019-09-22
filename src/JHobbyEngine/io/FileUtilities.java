package JHobbyEngine.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileUtilities {
    public static String readFile(String file) throws IOException {
        String data = "";

        BufferedReader reader = new BufferedReader(new FileReader(file));

        String line = "";
        while ((line = reader.readLine()) != null) {
            data.concat(line);
        }

        return data;
    }
}
