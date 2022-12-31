public class UniquePathsIII {
    int [][] dirs = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private int solve(int[][] grid, int countBlocks, int startX, int startY, boolean[][] visited){
        if(grid[startX][startY] ==  2){
            if(countBlocks == -1)
                return 1;
            return 0;
        }
        visited[startX][startY] = true;
        int countPaths = 0;
        for(int[] dir: dirs){
            int toMoveX = startX + dir[0];
            int toMoveY = startY + dir[1];
            if(toMoveX < 0 || toMoveY < 0 || toMoveX == grid.length || toMoveY == grid[0].length)
                continue;
            if(grid[toMoveX][toMoveY] == -1 || visited[toMoveX][toMoveY]) continue;
            countPaths += solve(grid, countBlocks - 1, toMoveX, toMoveY, visited);
        }
        visited[startX][startY] = false;
        return countPaths;
    }
    public int uniquePathsIII(int[][] grid) {
        int countBlocks = 0, start[] = new int[2];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0) countBlocks ++;
                else if(grid[i][j] == 1) {
                    start[0] = i; 
                    start[1] = j;
                }
            }
        }
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        return solve(grid, countBlocks, start[0], start[1], visited);
    }
}
