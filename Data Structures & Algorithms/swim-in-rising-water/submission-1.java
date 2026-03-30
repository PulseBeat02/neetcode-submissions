class Solution {
public int swimInWater(int[][] grid) {
    int n = grid.length;

    Queue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    heap.offer(new int[] { grid[0][0], 0, 0 });

    Set<String> visited = new HashSet<>();
    int[][] directions = { {1,0}, {-1,0}, {0,1}, {0,-1} };

    while (!heap.isEmpty()) {
        int[] node = heap.poll();
        int t = node[0], r = node[1], c = node[2];

        String hash = r + "," + c;
        if (visited.contains(hash)) continue;
        visited.add(hash);

        if (r == n - 1 && c == n - 1) return t;

        for (int[] disp : directions) {
            int nR = r + disp[0];
            int nC = c + disp[1];
            if (nR < 0 || nR >= n || nC < 0 || nC >= n) continue;

            String nHash = nR + "," + nC;
            if (visited.contains(nHash)) continue;

            int nt = Math.max(t, grid[nR][nC]);
            heap.offer(new int[] { nt, nR, nC });
        }
    }
    return -1;
}

}
