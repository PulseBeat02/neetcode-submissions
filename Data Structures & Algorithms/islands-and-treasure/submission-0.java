class Solution {
    public void islandsAndTreasure(int[][] grid) {

        int[][] min = new int[grid.length][grid[0].length];
        for (int[] arr : min) Arrays.fill(arr, Integer.MAX_VALUE);

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    min[i][j] = 0;
                    queue.add(new int[] {i, j});
                }
            }
        }

        int[][] disp = {
            {1, 0}, {-1, 0},
            {0, 1}, {0, -1}
        };

        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] indices = queue.poll();
                min[indices[0]][indices[1]] = Math.min(min[indices[0]][indices[1]], distance);
                for (int[] d : disp) {
                    int nR = indices[0] + d[0];
                    int nC = indices[1] + d[1];
                    if (isValid(grid, nR, nC) && grid[nR][nC] != -1 && distance < min[nR][nC]) queue.add(new int[] {nR, nC});
                }
            }
            distance++;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == -1) continue;
                grid[i][j] = min[i][j];
            }
        }

    }

    public boolean isValid(int[][] grid, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }

}
