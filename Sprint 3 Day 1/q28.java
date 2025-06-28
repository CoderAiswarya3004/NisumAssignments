import java.util.*;

class PrimeSumTask extends Thread {
    private final int start, end;
    private int localSum = 0;

    public PrimeSumTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public void run() {
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                localSum += i;
            }
        }
    }

    public int getLocalSum() {
        return localSum;
    }

    private boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i*i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}

public class PrimeSumThreads {
    public static void main(String[] args) throws InterruptedException {
        int limit = 100;
        int threadCount = 4;
        int range = limit / threadCount;

        PrimeSumTask[] tasks = new PrimeSumTask[threadCount];

        int start = 2;
        for (int i = 0; i < threadCount; i++) {
            int end = (i == threadCount - 1) ? limit : start + range - 1;
            tasks[i] = new PrimeSumTask(start, end);
            tasks[i].start();
            start = end + 1;
        }

        int totalSum = 0;
        for (PrimeSumTask task : tasks) {
            task.join();
            totalSum += task.getLocalSum();
        }

        System.out.println("Sum of all prime numbers up to " + limit + " = " + totalSum);
    }
}
