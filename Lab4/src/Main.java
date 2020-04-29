import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int rowA,columnA,rowB,columnB;
        double[][] a,b;
        CountDownLatch latch1,latch2;
        while (true){
            System.out.println("输入两个矩阵的大小:");
            Scanner input = new Scanner(System.in);
            rowA = input.nextInt();
            columnA = input.nextInt();
            rowB = input.nextInt();
            columnB = input.nextInt();

            long totalTime1 = 0;
            long totalTime2 = 0;

//            for (int i = 0; i < 10; i++){
                a = MatrixGenerator.getRandomMatrix(rowA,columnA,0,10000);
                b = MatrixGenerator.getRandomMatrix(rowB,columnB,0,10000);
                latch1 = new CountDownLatch(1);
                Thread thread = new Thread(new SerialMultiply(a,b,latch1));
                long startTime1 = System.currentTimeMillis();
                thread.start();
                latch1.await();
                long endTime1 = System.currentTimeMillis();
                totalTime1 += endTime1 -startTime1;

                latch2 = new CountDownLatch(2);
                Thread thread1 = new Thread(new ParallelMultiply(a,b,latch2,0));
                Thread thread2 = new Thread(new ParallelMultiply(a,b,latch2,1));
                long startTime2 = System.currentTimeMillis();
                thread1.start();
                thread2.start();

                latch2.await();
                long endTime2 = System.currentTimeMillis();
                totalTime2 += endTime2 -startTime2;
//            }

            System.out.println("串行执行平均耗时：" + totalTime1 + " ms");
            System.out.println("并行执行平均耗时：" + totalTime2 + " ms");
            System.out.println("-----------------------------------------------");
        }
    }
}
