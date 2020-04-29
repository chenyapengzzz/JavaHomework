import java.util.concurrent.CountDownLatch;

/**
 * 串行类
 */
public class SerialMultiply implements Runnable{
    private double[][] A;
    private double[][] B;
    private int row;
    private int column;
    private CountDownLatch latch;

    public SerialMultiply(double[][] a, double[][] b , CountDownLatch latch) {
        A = a;
        B = b;
        this.latch = latch;
        row = a.length;
        column = b[0].length;
    }

    @Override
    public void run() {
        double[][] C = new double[row][column];
        for (int i = 0 ; i < row ; i++){
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
