import java.util.Random;

public class RetryWithBackoff {

    public static boolean performNetworkCall() throws Exception {
        Random random = new Random();
        if (random.nextInt(10) < 7) { // 70% chance of failure
            throw new Exception("Network call failed.");
        }
        System.out.println("Network call succeeded!");
        return true;
    }

    public static void retryWithBackoff(int maxRetries, long initialDelayMillis) {
        int attempts = 0;
        long delay = initialDelayMillis;

        while (attempts < maxRetries) {
            try {
                attempts++;
                System.out.println("Attempt " + attempts);
                performNetworkCall();
                return; 
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                if (attempts == maxRetries) {
                    System.out.println("All retries exhausted. Operation failed.");
                    return;
                }
                System.out.println("Retrying in " + delay + " ms...");
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    System.out.println("Retry interrupted.");
                    return;
                }
                delay *= 2; // Exponential backoff
            }
        }
    }

    public static void main(String[] args) {
        retryWithBackoff(5, 1000); // 5 attempts, starting with 1s delay
    }
}
