import java.util.*;

public class SnakesandLadders {
    public int snakesAndLadders(int[][] arr) {
        int count = 0, n = arr.length;
        int[] board = new int[n * n];
        boolean flag = true;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (flag) {
                    board[count] = arr[i][j];
                } else {
                    board[count] = arr[i][n - j - 1];
                }
                count++;
            }
            flag = !flag;
        }
        n = board.length;
        Queue<int[]> que = new LinkedList<>();
        boolean[] visited = new boolean[n];
        que.offer(new int[] { 0, 0 });
        while (!que.isEmpty()) {
            int[] brr = que.poll();
            visited[brr[0]] = true;
            if (brr[0] == n - 1)
                return brr[1];
            for (int i = 1; i <= 6; i++) {
                if (brr[0] + i >= n)
                    continue;
                int jump = (board[brr[0] + i] == -1 ? brr[0] + i : board[brr[0] + i] - 1);
                if (!visited[jump]) {
                    que.offer(new int[] { jump, brr[1] + 1 });
                    visited[jump] = true;
                }
            }
        }
        return -1;
    }
}