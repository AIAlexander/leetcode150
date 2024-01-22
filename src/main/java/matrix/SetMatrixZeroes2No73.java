package matrix;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wsh
 * @date 2024/1/19
 */
public class SetMatrixZeroes2No73 {

    /**
     * 使用第一行第一列来标记此行此列是否存在0，节省空间
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {

        int rowLen = matrix[0].length;
        int colLen = matrix.length;

        boolean rowZero = false;
        boolean colZero = false;


        for (int j = 0; j < rowLen; j++) {
            if (matrix[0][j] == 0) {
                rowZero = true;
                break;
            }
        }

        for (int i = 0; i < colLen; i++) {
            if (matrix[i][0] == 0) {
                colZero = true;
                break;
            }
        }

        for (int i = 1; i < colLen; i++) {
            for (int j = 1; j < rowLen; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < colLen; i++) {
            for (int j = 1; j < rowLen; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (colZero) {
            for (int i = 0; i < colLen; i++) {
                matrix[i][0] = 0;
            }
        }
        if (rowZero) {
            for (int j = 0; j < rowLen; j++) {
                matrix[0][j] = 0;
            }
        }


    }

    public static void main(String[] args) {

    }
}
