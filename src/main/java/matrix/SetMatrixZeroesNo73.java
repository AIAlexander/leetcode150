package matrix;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wsh
 * @date 2024/1/19
 */
public class SetMatrixZeroesNo73 {

    public void setZeroes(int[][] matrix) {
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (rowSet.contains(i) || colSet.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
