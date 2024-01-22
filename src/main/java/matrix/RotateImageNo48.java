package matrix;

/**
 * @author wsh
 * @date 2024/1/19
 */
public class RotateImageNo48 {

    /**
     * 矩阵转90度 = 矩阵水平翻转 + 根据0，0对角线翻转
     * @param matrix
     */
    public static void rotate(int[][] matrix) {

        int n = matrix.length;

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = tmp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }

    public static void main(String[] args) {


        int[][] m = new int[][]{
                {5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}
        };

        rotate(m);

    }
}
