class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) queue.add(new int[] {r, c});
                if (grid[r][c] == 1) fresh++;
            }
        }

        int[][] directions = new int[][] {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };

        int stage = 0;
        int rotted = 0;
        while (!queue.isEmpty()) {
            int rotten = queue.size();
            for (int i = 0; i < rotten; i++) {
                int[] popped = queue.poll();
                int r = popped[0];
                int c = popped[1];
                for (int[] direction : directions) {
                    int nR = r + direction[0];
                    int nC = c + direction[1];
                    if (nR < 0 || nR >= rows || nC < 0 || nC >= cols) continue;
                    if (grid[nR][nC] != 1) continue;
                    if (grid[nR][nC] == 2) continue;
                    grid[nR][nC] = 2;
                    queue.add(new int[] {nR, nC});
                    rotted++;
                }
            }
            stage++;
        }

        return fresh == rotted ? Math.max(0, stage - 1) : -1;
    }
}
