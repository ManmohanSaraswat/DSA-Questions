public class WordSearch {
    private boolean dfs(char[][] board, int i, int j, char[] arr, boolean[][] visited, int n) {
        if (n == arr.length)
            return true;
        if (i < 0 || j < 0 || i == board.length || j == board[0].length || visited[i][j])
            return false;
        if (board[i][j] != arr[n])
            return false;
        n++;
        visited[i][j] = true;
        boolean res = dfs(board, i + 1, j, arr, visited, n) ||
                dfs(board, i - 1, j, arr, visited, n) ||
                dfs(board, i, j + 1, arr, visited, n) ||
                dfs(board, i, j - 1, arr, visited, n);
        visited[i][j] = false;
        return res;
    }

    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;
        char[] arr = word.toCharArray();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[0] == board[i][j] && dfs(board, i, j, arr, new boolean[n][m], 0))
                    return true;
            }
        }
        return false;
    }
}
