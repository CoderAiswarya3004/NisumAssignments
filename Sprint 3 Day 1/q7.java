import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GlobalExceptionLogger {

    public static void main(String[] args) {

        Thread.setDefaultUncaughtExceptionHandler((thread, throwable) -> {
            try (PrintWriter writer = new PrintWriter(new FileWriter("error_log.txt", true))) {
                writer.println("Exception in thread \"" + thread.getName() + "\": " + throwable);
                for (StackTraceElement elem : throwable.getStackTrace()) {
                    writer.println("\tat " + elem);
                }
                System.out.println("Logged unhandled exception to file.");
            } catch (IOException e) {
                System.out.println("Failed to log exception: " + e.getMessage());
            }
        });
      
        System.out.println("This will throw an exception:");
        int result = 10 / 0; 
        System.out.println("End of program.");
    }
}
