import java.io.IOException;
import java.util.logging.*;
import java.util.logging.Logger;

public class UncheckedException {

    private static final Logger LOG = Logger.getLogger(UncheckedException.class.getName());

    static void divisionByZero() throws IOException {
        FileHandler fh = new FileHandler("log_uncheked.log");
        fh.setLevel(Level.INFO);
        fh.setFormatter(new SimpleFormatter());
        LOG.addHandler(fh);

        try {
            int a = 1 / 0;  // ArithmeticException: / by zero
        } catch (ArithmeticException e) {
            LOG.log(Level.INFO, "error divison by zero", e);
        }
    }

    public static void main(String[] args) throws IOException {
        divisionByZero();
    }


}
