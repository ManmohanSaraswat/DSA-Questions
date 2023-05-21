public class FindtheLosersoftheCircularGame {
    public int[] circularGameLosers(int n, int k) {
        int[] arr = new int[n];
        int turn = 1, cur = 0;
        arr[0] = 1;
        while (turn < 10000) {
            cur = (cur + k * turn) % n;
            if (arr[cur] == 1)
                break;
            arr[cur] = 1;
            turn++;
        }
        int m = 0, cnt = 0;
        for (int i = 0; i < n; i++)
            if (arr[i] != 1)
                cnt++;
        int[] res = new int[cnt];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                res[m] = i + 1;
                m++;
            }
        }
        return res;
    }
}
