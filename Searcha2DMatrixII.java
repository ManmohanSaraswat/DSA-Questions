import java.util.Arrays;

public class Searcha2DMatrixII {
    public boolean searchMatrixONLOGN(int[][] matrix, int target) {
        for(int i = 0; i < matrix.length; i++){
            if(Arrays.binarySearch(matrix[i], target) >= 0) return true;
        }
        return false;
    }
}
