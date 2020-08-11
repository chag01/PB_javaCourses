import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.*;
import java.util.logging.Logger;

public class CheckedException {

    private static final Logger LOG1 = Logger.getLogger(CheckedException.class.getName());

    static void scannerCallWithWrongFilePath() throws Exception {
        FileHandler fh = new FileHandler("log_checkedException.log");
        fh.setLevel(Level.ALL);
        fh.setFormatter(new SimpleFormatter());
        LOG1.setLevel(Level.ALL);
        LOG1.addHandler(fh);

        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.ALL);
        LOG1.addHandler(ch);

        File file = new File("testPathName");
        try {
            Scanner scanner = new Scanner(file);  // FileNotFoundException
        } catch (FileNotFoundException e) {
            LOG1.log(Level.ALL, "File Not Found", e);
        }
    }

    public static void main(String[] args) throws Exception {
        scannerCallWithWrongFilePath();
    }
}
