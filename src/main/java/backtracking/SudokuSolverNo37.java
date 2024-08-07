package backtracking;

/**
 * @author wsh
 * @date 2024/8/7
 */
public class SudokuSolverNo37 {

    public void solveSudoku(char[][] board) {
        backtracking(board);
    }

    public boolean backtracking(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    continue;
                }
                for (char num = '1'; num <= '9'; num++) {
                    if (isValid(board, i, j, num)) {
                        board[i][j] = num;
                        if (backtracking(board)) {
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean solveSudokuHelper(char[][] board){
        //「一个for循环遍历棋盘的行，一个for循环遍历棋盘的列，
        // 一行一列确定下来之后，递归遍历这个位置放9个数字的可能性！」
        for (int i = 0; i < 9; i++){ // 遍历行
            for (int j = 0; j < 9; j++){ // 遍历列
                if (board[i][j] != '.'){ // 跳过原始数字
                    continue;
                }
                for (char k = '1'; k <= '9'; k++){ // (i, j) 这个位置放k是否合适
                    if (isValid(board, i, j, k)){
                        board[i][j] = k;
                        if (solveSudokuHelper(board)){ // 如果找到合适一组立刻返回
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }
                // 9个数都试完了，都不行，那么就返回false
                return false;
                // 因为如果一行一列确定下来了，这里尝试了9个数都不行，说明这个棋盘找不到解决数独问题的解！
                // 那么会直接返回， 「这也就是为什么没有终止条件也不会永远填不满棋盘而无限递归下去！」
            }
        }
        // 遍历完没有返回false，说明找到了合适棋盘位置了
        return true;
    }

    private boolean isValidSudoku(int row, int col, char val, char[][] board){
        // 同行是否重复
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == val) {
                return false;
            }
        }
        // 同列是否重复
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == val) {
                return false;
            }
        }
        // 9宫格里是否重复
        int leftCol = (col / 3 ) * 3;
        int rightCol = leftCol + 2;

        int leftRow = (row / 3) * 3;
        int rightRow = leftRow + 2;

        for (int i = leftRow; i <= rightRow; i++) {
            for (int j = leftCol; j <= rightCol; j++) {
                if (board[i][j] == val) {
                    return false;
                }
            }
        }
        return true;
    }


    public boolean isValid(char[][] board, int row, int col, char number) {
        // 横向比较
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == number) {
                return false;
            }
        }

        // 纵向比较
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == number) {
                return false;
            }
        }

        // 方格之内比较
        // 求出(row,col)位置所处的方格大小范围
        int leftCol = (col / 3 ) * 3;
        int rightCol = leftCol + 2;

        int leftRow = (row / 3) * 3;
        int rightRow = leftRow + 2;

        for (int i = leftRow; i <= rightRow; i++) {
            for (int j = leftCol; j <= rightCol; j++) {
                if (board[i][j] == number) {
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};

        SudokuSolverNo37 s = new SudokuSolverNo37();
        s.solveSudoku(board);

        System.out.println(board);
    }
}
