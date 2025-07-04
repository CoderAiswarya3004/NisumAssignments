class MatrixMultiplier extends Thread {
    private final int[][] A;
    private final int[][] B;
    private final int[][] result;
    private final int row;

    public MatrixMultiplier(int[][] A, int[][] B, int[][] result, int row) {
        this.A = A;
        this.B = B;
        this.result = result;
        this.row = row;
    }

    public void run() {
        int colsB = B[0].length;
        int colsA = A[0].length;

        for (int j = 0; j < colsB; j++) {
            for (int k = 0; k < colsA; k++) {
                result[row][j] += A[row][k] * B[k][j];
            }
        }
    }
}

public class MatrixMultiplication {
    public static void main(String[] args) throws InterruptedException {
        int[][] A = {
            {1, 2},
            {3, 4}
        };
        int[][] B = {
            {5, 6},
            {7, 8}
        };

        int rowsA = A.length;
        int colsB = B[0].length;

        int[][] result = new int[rowsA][colsB];

        Thread[] threads = new Thread[rowsA];

        for (int i = 0; i < rowsA; i++) {
            threads[i] = new MatrixMultiplier(A, B, result, i);
            threads[i].start();
        }
        for (int i = 0; i < rowsA; i++) {
            threads[i].join();
        }
        System.out.println("Result Matrix:");
        for (int[] row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
