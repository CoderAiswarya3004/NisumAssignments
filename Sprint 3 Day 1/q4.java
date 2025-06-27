import java.io.IOException;
import java.io.UncheckedIOException;

public class UncheckedWrapper {
    public static void legacyIOCall() throws IOException {
        throw new IOException("Legacy IO operation failed.");
    }
    public static void callWithUncheckedWrapper() {
        try {
            legacyIOCall();
        } catch (IOException e) {
            throw new UncheckedIOException("Wrapped IOException as unchecked", e);
        }
    }

    public static void main(String[] args) {
        try {
            callWithUncheckedWrapper();
        } catch (UncheckedIOException e) {
            System.out.println("Caught UncheckedIOException: " + e.getMessage());
        }
    }
}
