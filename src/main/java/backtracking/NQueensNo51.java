package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wsh
 * @date 2024/8/7
 */
public class NQueensNo51 {

    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        String[][] path = new String[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                path[j][i] = ".";
            }
        }
        backtracking(0, path);
        return result;
    }

    /**
     * 逻辑：行 为选取位置，列为递归的深度
     *      即：先放第一行，然后递归放第二行，以此类推
     * 其中 row表示行数，col表示列数
     * @param row
     * @param path
     */
    public void backtracking(int row, String[][] path) {
        // row等于棋盘的大小，说明已经放置成功，搜集结果
        if (row == path.length) {
            List<String> tmp = new ArrayList<>();
            for (int i = 0; i < path.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j <path[0].length; j++) {
                    sb.append(path[i][j]);
                }
                tmp.add(sb.toString());
            }
            result.add(tmp);
            return;
        }
        // 当前row，遍历col，一个位置一个位置放
        for (int col = 0; col < path.length; col++) {
            // 判断当前放置的位置是否合法，不合法就选下一个位置
            if (!isValid(path, col, row)) {
                continue;
            }
            path[row][col] = "Q";
            backtracking(row + 1, path);
            path[row][col] = ".";
        }
    }


    /**
     * N皇后判断当前位置是否合法
     * 判断4个位置
     *      当前行，当前列，左上45度，右上45度（因为棋子是一行一行放的，因此无需判断右下和左下）
     *
     * @param path
     * @param col
     * @param row
     * @return
     */
    public boolean isValid (String[][] path, int col, int row) {
        int width = 0;
        int height = 0;
        // 横向判断
        while (width < path[0].length) {
            if ("Q".equals(path[row][width])) {
                return false;
            }
            width++;
        }
        // 纵向判断
        while (height < path.length) {
            if ("Q".equals(path[height][col])) {
                return false;
            }
            height++;
        }

        // 左上45度判断
        int ax = col;
        int ay = row;
        while (ax >= 0 && ay >= 0) {
            if ("Q".equals(path[ay][ax])) {
                return false;
            }
            ax--;
            ay--;
        }

        // 右上45度判断
        ax = col;
        ay = row;
        while (ax >= 0 && ay >= 0 && ax < path[0].length && ay < path.length) {
            if ("Q".equals(path[ay][ax])) {
                return false;
            }
            ax++;
            ay--;
        }

        return true;
    }

    public static void main(String[] args) {
        NQueensNo51 q = new NQueensNo51();
        List<List<String>> lists = q.solveNQueens(1);
        System.out.println(lists);
    }
}
