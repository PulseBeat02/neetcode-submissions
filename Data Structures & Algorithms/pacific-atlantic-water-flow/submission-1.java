class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];
        for (int c = 0; c < cols; c++) {
            dfs(0, c, pacific, heights);
            dfs(rows - 1, c, atlantic, heights);
        }
        for (int r = 0; r < rows; r++) {
            dfs(r, 0, pacific, heights);
            dfs(r, cols - 1, atlantic, heights);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacific[r][c] && atlantic[r][c]) ans.add(List.of(r, c));
            }
        }

        return ans;
    }

    public void dfs(int r, int c, boolean[][] seen, int[][] heights) {
        seen[r][c] = true;
        int[][] directions = new int[][] {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };
        int rows = heights.length;
        int cols = heights[0].length;
        for (int[] direction : directions) {
            int nR = r + direction[0];
            int nC = c + direction[1];
            if (nR < 0 || nR >= rows || nC < 0 || nC >= cols) continue;
            if (seen[nR][nC]) continue;
            if (heights[nR][nC] < heights[r][c]) continue;
            dfs(nR, nC, seen, heights);
        }
    }
}
