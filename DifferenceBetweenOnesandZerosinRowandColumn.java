public class DifferenceBetweenOnesandZerosinRowandColumn {
    public int[][] onesMinusZeros(int[][] grid) {
        int cols[] = new int[grid[0].length], rows[] = new int[grid.length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                rows[i] += grid[i][j];
                cols[j] += grid[i][j];
            }
        }
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                grid[i][j] = rows[i] + cols[j] - (grid.length - rows[i]) - (grid[0].length - cols[j]);
            }
        }
        return grid;
    }
}
