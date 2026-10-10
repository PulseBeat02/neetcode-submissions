class Solution {

    class DSU {

        private int[] parent;
        private int[] size;

        public DSU(int n) {
            this.parent = new int[n];
            this.size = new int[n];
            for (int i = 0; i < n; i++) {
                this.parent[i] = i;
                this.size[i] = 1;
            }
        }

        public int find(int node) {
            if (parent[node] != node) {
                parent[node] = find(parent[node]);
            }
            return parent[node];
        }

        public boolean union(int a, int b) {
            int first = find(a);
            int second = find(b);
            if (first == second) return false;
            if (size[first] < size[second]) {
                int temp = first;
                first = second;
                second = temp;
            }
            parent[second] = first;
            size[first] += size[second];
            return true;
        }

        public boolean connected(int a, int b) {
            return find(a) == find(b);
        }
    }

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        DSU dsu = new DSU(n * n);
        List<int[]> list = new ArrayList<>();
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                list.add(new int[] {grid[r][c], r, c});
            }
        }
        list.sort(Comparator.comparingInt(a -> a[0]));
        int[][] directions = new int[][] {
            {1, 0}, {0, 1}, {-1, 0}, {0, -1}
        };
        for (int i = 0; i < n * n; i++) {
            int[] point = list.get(i);
            for (int[] direction : directions) {
                int nR = point[1] + direction[0];
                int nC = point[2] + direction[1];
                if (nR < 0 || nR >= n || nC < 0 || nC >= n) continue;
                if (grid[nR][nC] > point[0]) continue;
                dsu.union(point[1] * n + point[2], nR * n + nC);
            }
            if (dsu.connected(0, n * n - 1)) return point[0];
        }
        return n * n;
    }
}






