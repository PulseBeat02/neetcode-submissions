class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 0) queue.add(new int[] {r, c});
            }
        }
        int[][] directions = new int[][] {
            {1, 0}, {0, 1}, {-1, 0}, {0, -1}
        };
        int distance = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pop = queue.poll();
                int r = pop[0];
                int c = pop[1];            
                    for (int[] direction : directions) {
                    int nR = r + direction[0];
                    int nC = c + direction[1];
                    if (nR < 0 || nR >= rows || nC < 0 || nC >= cols) continue;
                    if (grid[nR][nC] == -1) continue;
                    if (grid[nR][nC] != Integer.MAX_VALUE) continue;
                    grid[nR][nC] = distance;
                    queue.add(new int[] {nR, nC});
                }
            }
            distance++;
        }
    }
}
