class Counter {
    int count = 0;
    public void increment() {
        count++;
    }
}

class CounterSync {
    int count = 0;
    public synchronized void increment() {
        count++;
    }
}

public class SharedCounter {

    public static void main(String[] args) throws InterruptedException {

        Counter unsyncCounter = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                unsyncCounter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                unsyncCounter.increment();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Without Synchronization: " + unsyncCounter.count);
        CounterSync syncCounter = new CounterSync();

        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                syncCounter.increment();
            }
        });

        Thread t4 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                syncCounter.increment();
            }
        });

        t3.start();
        t4.start();
        t3.join();
        t4.join();
        System.out.println("With Synchronization: " + syncCounter.count);
    }
}
