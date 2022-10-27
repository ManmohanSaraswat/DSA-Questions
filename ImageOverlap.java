public class ImageOverlap {
    public int largestOverlap(int[][] arr, int[][] brr) {
        int n = arr.length, totSize = 3 * arr.length + 1;
        int matrix[][] = new int[totSize][totSize];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++)
                matrix[n + i][n + j] = arr[i][j];
        }
        int max = 0;
        for(int i = 0; i + n < totSize; i++){
            for(int j = 0; j + n < totSize; j++){
                int cur = 0;
                for(int x = 0; x < n; x ++){
                    for(int y = 0; y < n; y++){
                        if(matrix[i + x][j + y] == brr[x][y] && brr[x][y] == 1) cur++;
                    }
                }
                max = Math.max(max, cur);
            }
        }
        return max;
    } 
}
