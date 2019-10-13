package JHobbyEngine.io;

import org.lwjgl.BufferUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public static String readFile(String file) throws IOException {
        return readFile(file, true);
    }

    public static BufferedImage readImageFile(String file) throws IOException {
        return ImageIO.read(new File(file));
    }
}
