class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                max = Math.max(dfs(grid, new boolean[rows][cols], i, j), max);
            }
        }
        return max;
    }

    public int dfs(int[][] grid, boolean[][] visited, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) return 0;
        if (grid[r][c] == 0) return 0;
        if (visited[r][c]) return 0;
        visited[r][c] = true;
        return dfs(grid, visited, r + 1, c) + dfs(grid, visited, r - 1, c) + dfs(grid, visited, r, c + 1) + dfs(grid, visited, r, c - 1) + 1;
    }
}
