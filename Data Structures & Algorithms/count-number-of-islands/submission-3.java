class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    dfs(grid, r, c);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int r, int c) {
        int rows = grid.length;
        int cols = grid[0].length;
        if (r < 0 || r >= rows || c < 0 || c >= cols) return;
        if (grid[r][c] == '0') return;
        grid[r][c] = '0';
        int[][] displacements = new int[][] {
            {1, 0}, {0, 1}, {-1, 0}, {0, -1}
        };
        for (int[] displacement : displacements) {
            dfs(grid, r + displacement[0], c + displacement[1]);
        }
    }
}
