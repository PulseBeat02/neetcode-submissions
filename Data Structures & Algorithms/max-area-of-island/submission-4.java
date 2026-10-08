class Solution {

    int currentArea = 0;

    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int max = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    dfs(grid, r, c);
                    max = Math.max(currentArea, max);
                    currentArea = 0;
                }
            }
        }
        return max;
    }

    public void dfs(int[][] grid, int r, int c) {
        int rows = grid.length;
        int cols = grid[0].length;
        if (r < 0 || r >= rows || c < 0 || c >= cols) return;
        if (grid[r][c] == 0) return;
        grid[r][c] = 0;
        currentArea++;
        int[][] displacements = new int[][] {
            {1, 0}, {0, 1}, {-1, 0}, {0, -1}
        };
        for (int[] displacement : displacements) {
            dfs(grid, r + displacement[0], c + displacement[1]);
        }
    }
}
