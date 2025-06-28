import java.util.Arrays;

class SortThread extends Thread {
    private int[] array;

    public SortThread(int[] array) {
        this.array = array;
    }

    public void run() {
        Arrays.sort(array); 
    }

    public int[] getSortedArray() {
        return array;
    }
}

public class MultithreadedSort {

    public static void main(String[] args) throws InterruptedException {
        int[] input = {34, 7, 23, 32, 5, 62, 18, 14};

        int mid = input.length / 2;
        int[] left = Arrays.copyOfRange(input, 0, mid);
        int[] right = Arrays.copyOfRange(input, mid, input.length);

        SortThread t1 = new SortThread(left);
        SortThread t2 = new SortThread(right);
      
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        int[] merged = merge(t1.getSortedArray(), t2.getSortedArray());
        System.out.println("Original: " + Arrays.toString(input));
        System.out.println("Sorted:   " + Arrays.toString(merged));
    }
    public static int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            result[k++] = (a[i] < b[j]) ? a[i++] : b[j++];
        }
        while (i < a.length) result[k++] = a[i++];
        while (j < b.length) result[k++] = b[j++];
        return result;
    }
}
