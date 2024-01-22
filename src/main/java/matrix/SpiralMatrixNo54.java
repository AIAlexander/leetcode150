package matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wsh
 * @date 2024/1/19
 */
public class SpiralMatrixNo54 {


    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res =  new ArrayList<>();
        int n = Math.min(matrix.length, matrix[0].length);

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        int offset = 1;
        int loop = 0;
        int startx = 0;
        int i,j;

        while (loop < n / 2) {

            for (i = startx; i < matrix[0].length - offset; i++) {
                visited[startx][i] = true;
                res.add(matrix[startx][i]);
            }

            for (j = startx; j < matrix.length - offset; j++) {
                visited[j][i] = true;
                res.add(matrix[j][i]);
            }

            for (; i > offset - 1; i--) {
                visited[j][i] = true;
                res.add(matrix[j][i]);
            }

            for (; j > offset - 1; j--) {
                visited[j][i] = true;
                res.add(matrix[j][i]);
            }

            offset++;
            loop++;
            startx++;
        }

        if (matrix.length == matrix[0].length) {
            if (matrix.length % 2 == 1) {
                res.add(matrix[startx][startx]);
            }
        } else if (matrix.length > matrix[0].length){
            for (int k = startx; k < matrix.length - offset + 1; k++) {
                if (!visited[k][startx]) {
                    res.add(matrix[k][startx]);
                }

            }
        } else {
            for (int k = startx; k < matrix[0].length - offset + 1; k++) {
                if (!visited[startx][k]) {
                    res.add(matrix[startx][k]);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {


        int[][] m = new int[][] {
                {2,5},
                {8,4},
                {0,-1}
        };

        spiralOrder(m);
    }
}
