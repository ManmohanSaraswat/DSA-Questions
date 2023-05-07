public class NumberofAdjacentElementsWiththeSameColor {
    public int[] colorTheArray(int n, int[][] queries) {
        int[] arr = new int[n];
        int res[] = new int[queries.length], prevRes = 0, count = 0;
        for (int query[] : queries) {
            int ind = query[0];
            if (ind > 0 && ind < n - 1 && arr[ind] != 0) {
                if (arr[ind - 1] == arr[ind] && arr[ind] == arr[ind + 1])
                    prevRes -= 2;
                else if (arr[ind - 1] == arr[ind])
                    prevRes--;
                else if (arr[ind] == arr[ind + 1])
                    prevRes--;
            }
            if (ind == 0 && ind + 1 < n && arr[ind] != 0) {
                if (arr[ind] == arr[ind + 1])
                    prevRes -= 1;
            } else if (ind == n - 1 && ind - 1 >= 0 && arr[ind] != 0) {
                if (arr[ind] == arr[ind - 1])
                    prevRes -= 1;
            }

            arr[ind] = query[1];
            if (ind > 0 && ind < n - 1) {
                if (arr[ind - 1] == arr[ind] && arr[ind] == arr[ind + 1])
                    prevRes += 2;
                else if (arr[ind - 1] == arr[ind])
                    prevRes++;
                else if (arr[ind] == arr[ind + 1])
                    prevRes++;
            }
            if (ind == 0 && ind + 1 < n) {
                if (arr[ind] == arr[ind + 1])
                    prevRes += 1;
            } else if (ind == n - 1 && ind - 1 >= 0) {
                if (arr[ind] == arr[ind - 1])
                    prevRes += 1;
            }
            res[count] = prevRes;
            count++;
        }
        return res;
    }
}
