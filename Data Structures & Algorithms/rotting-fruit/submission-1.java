class Solution {
    public int orangesRotting(int[][] grid) {

        Set<String> fresh = new HashSet<>();
        Queue<int[]> rotten = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) fresh.add(i + "," + j);
                if (grid[i][j] == 2) rotten.add(new int[] {i, j});
            }
        }

        int time = 0;
        int[][] disp = {
            {1, 0}, {-1, 0},
            {0, 1}, {0, -1}
        };
        while (!fresh.isEmpty()) {
            int numRotten = rotten.size();
            if (numRotten == 0) {
                time = -1;
                break;
            }
            for (int i = 0; i < numRotten; i++) {
                int[] indices = rotten.poll();
                for (int[] d : disp) {
                    int nR = indices[0] + d[0];
                    int nC = indices[1] + d[1];
                    if (nR < 0 || nR >= grid.length || nC < 0 || nC >= grid[0].length) continue;
                    if (grid[nR][nC] != 1) continue;
                    grid[nR][nC] = 2;
                    fresh.remove(nR + "," + nC);
                    rotten.add(new int[] {nR, nC});
                }
            }
            time++;
        }

        return time;
    }
}
