import java.util.concurrent.CountDownLatch;

/**
 * 并行类
 */
public class ParallelMultiply implements Runnable{
    private double[][] A;
    private double[][] B;
    private int row;
    private int column;
    private int temp;
    private CountDownLatch latch;

    public ParallelMultiply(double[][] a, double[][] b, CountDownLatch latch, int temp){
        A = a;
        B = b;
        this.latch = latch;
        this.temp = temp;
        row = a.length;
        column = b[0].length;
    }

    @Override
    public void run() {
        double[][] C = new double[row][column];
        for (int i = temp ; i < row ; i += 2){
            for (int j = 0 ; j < column ; j++){
                double res = 0;
                for (int k = 0 ; k < A[0].length ; k++){
                    res += A[i][k]*B[k][j];
                }
                C[i][j] = res;
            }
        }
        latch.countDown();
    }
}
