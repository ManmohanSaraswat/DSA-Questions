public class RotateImage{
    public void solve(int[][] matrix, int start, int end){
        int leftTop[] = new int[]{start, start};
        int rightTop[] = new int[]{start, end - 1};
        int bottomLeft[] = new int[]{end - 1, start};
        int bottomRight[] = new int[]{end - 1, end - 1};
        for(int i = start; i < end - 1; i++){
            int temp = matrix[bottomLeft[0]][bottomLeft[1]];
            matrix[bottomLeft[0]][bottomLeft[1]] = matrix[bottomRight[0]][bottomRight[1]];
            matrix[bottomRight[0]][bottomRight[1]] = matrix[rightTop[0]][rightTop[1]];
            matrix[rightTop[0]][rightTop[1]] = matrix[leftTop[0]][leftTop[1]];
            matrix[leftTop[0]][leftTop[1]] = temp;
            leftTop[1]++;
            rightTop[0]++;
            bottomRight[1] --;
            bottomLeft[0] -- ;
        }
        
    }
    public void rotate(int[][] matrix) {
        for(int i = 0; i < matrix.length / 2; i++)
            solve(matrix, i, matrix.length - i);
    }

    public void rotateUsingMath(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length / 2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - j - 1];
                matrix[i][matrix.length - j - 1] = temp;
            }
        }
    }
}