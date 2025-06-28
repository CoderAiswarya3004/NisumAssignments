import java.util.LinkedList;
import java.util.Queue;

class Buffer {
    private final Queue<Integer> queue = new LinkedList<>();
    private final int capacity = 5;

    public synchronized void produce(int value) throws InterruptedException {
        while (queue.size() == capacity) {
            wait(); 
        }

        queue.offer(value);
        System.out.println("Produced: " + value);
        notify(); 
    }

    public synchronized int consume() throws InterruptedException {
        while (queue.isEmpty()) {
            wait(); 
        }

        int value = queue.poll();
        System.out.println("Consumed: " + value);
        notify(); 
        return value;
    }
}

class Producer extends Thread {
    private final Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        int value = 1;
        while (value <= 10) {
            try {
                buffer.produce(value++);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}

class Consumer extends Thread {
    private final Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        int count = 0;
        while (count < 10) {
            try {
                buffer.consume();
                Thread.sleep(150); 
                count++;
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        Thread producer = new Producer(buffer);
        Thread consumer = new Consumer(buffer);
        producer.start();
        consumer.start();
    }
}
