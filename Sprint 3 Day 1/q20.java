class EvenThread extends Thread {
    public void run() {
        for (int i = 2; i <= 10; i += 2) {
            System.out.println("Even: " + i);
            try {
                Thread.sleep(100); // pause to simulate processing
            } catch (InterruptedException e) {
                System.out.println("Even thread interrupted");
            }
        }
    }
}

class OddThread extends Thread {
    public void run() {
        for (int i = 1; i < 10; i += 2) {
            System.out.println("Odd: " + i);
            try {
                Thread.sleep(100); // pause to simulate processing
            } catch (InterruptedException e) {
                System.out.println("Odd thread interrupted");
            }
        }
    }
}

public class OddEvenThreads {
    public static void main(String[] args) {
        Thread even = new EvenThread();
        Thread odd = new OddThread();

        even.start();
        odd.start();
    }
}
