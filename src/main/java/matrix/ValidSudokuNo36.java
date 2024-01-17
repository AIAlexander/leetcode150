package matrix;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author wsh
 * @date 2024/1/17
 */
public class ValidSudokuNo36 {

    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Integer>> colMap = new HashMap<>();
        Map<Integer, Set<Integer>> rowMap = new HashMap<>();
        Map<Integer, Set<Integer>> areaMap = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            colMap.put(i, new HashSet<>());
            rowMap.put(i, new HashSet<>());
            areaMap.put(i, new HashSet<>());
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int num = board[i][j] - '0';
                int index = i / 3 * 3 + j / 3;
                if (colMap.get(j).contains(num) || rowMap.get(i).contains(num) || areaMap.get(index).contains(num)) {
                    return false;
                }
                rowMap.get(i).add(num);
                colMap.get(j).add(num);
                areaMap.get(index).add(num);
            }
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
