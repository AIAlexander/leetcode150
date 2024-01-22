package matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wsh
 * @date 2024/1/19
 */
public class SpiralMatrixIINo59 {


    public static int[][] spiralOrder(int n) {

        int[][] res = new int[n][n];

        int count = 1;
        int offset = 1;
        int loop = 0;
        int startx = 0;
        int i, j;

        while (loop < n / 2) {

            for (i = startx; i < n - offset; i++) {
                res[startx][i] = count;
                count++;
            }

            for (j = startx; j < n - offset; j++) {
                res[j][i] = count;
                count++;
            }

            for (; j > offset - 1; j--) {
                res[i][j] = count;
                count++;
            }

            for (; i > offset - 1; i--) {
                res[i][j] = count;
                count++;
            }


            loop++;
            offset++;
            startx++;
        }

        if (n % 2 == 1) {
            res[startx][startx] = count;
        }

        return res;
    }

    public static void main(String[] args) {


        spiralOrder(5);
    }
}
