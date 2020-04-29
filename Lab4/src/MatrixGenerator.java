import java.util.Random;

/**
 * 工具类，生成随机矩阵
 * @author tju cyp
 */

public class MatrixGenerator {
    private static Random random = new Random();
    /**
     * 生成指定大小的随机矩阵,元素大小在[min,max]区间内
     * @param row
     * @param column
     * @param min
     * @param max
     * @return
     */
    public static double[][] getRandomMatrix(int row, int column, long min, long max){
        double[][] matrix = new double[row][column];
        for (int i = 0 ; i < row ; i++){
            for (int j = 0 ; j < column ; j++){
                matrix[i][j] = min + random.nextDouble()*(max-min);
            }
        }
        return matrix;
    }
}
