import java.util.*;

public class MiceandCheese {
    public int miceAndCheese(int[] arr, int[] brr, int k) {
        Queue<int[]> que = new PriorityQueue<>((a, b) -> Integer.compare(b[0] - b[1], a[0] - a[1]));
        for (int i = 0; i < arr.length; i++)
            que.offer(new int[] { arr[i], brr[i] });
        int left = arr.length - k, res = 0;
        for (int i = 0; i < k; i++) {
            res += que.poll()[0];
        }
        while (!que.isEmpty()) {
            int l[] = que.poll();
            res += l[1];
        }
        return res;
    }
}
