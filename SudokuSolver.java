public class SudokuSolver {
    private static boolean solve(char[][] board, int[] rows, int[] cols, int[][] subBoxes) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    boolean flag = false;
                    for (int k = 1; k <= 9; k++) {
                        if ((rows[i] & (1 << k)) == 0 && (cols[j] & (1 << k)) == 0 &&
                                (subBoxes[i / 3][j / 3] & (1 << k)) == 0) {
                            rows[i] ^= (1 << k);
                            cols[j] ^= (1 << k);
                            subBoxes[i / 3][j / 3] ^= (1 << k);
                            board[i][j] = (char) (k + '0');
                            if (solve(board, rows, cols, subBoxes)) {
                                flag = true;
                                break;
                            }
                            board[i][j] = '.';
                            rows[i] ^= (1 << k);
                            cols[j] ^= (1 << k);
                            subBoxes[i / 3][j / 3] ^= (1 << k);
                        }
                    }
                    if (!flag)
                        return false;
                }
            }
        }
        return true;
    }

    public void solveSudoku(char[][] board) {
        int rows[] = new int[9], cols[] = new int[9], subBoxes[][] = new int[3][3];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    rows[i] |= (1 << (board[i][j] - '0'));
                    cols[j] |= (1 << (board[i][j] - '0'));
                    subBoxes[i / 3][j / 3] |= (1 << (board[i][j] - '0'));
                }
            }
        }
        solve(board, rows, cols, subBoxes);
    }
}