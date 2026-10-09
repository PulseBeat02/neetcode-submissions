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

        public boolean union(int u, int v) {
            int first = find(u);
            int second = find(v);
            if (first == second) return false;

            if (size[second] > size[first]) { // make second always smaller than first
                int temp = first;
                first = second;
                second = temp;
            }

            parent[second] = first;
            size[first] += size[second];

            return true;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DSU dsu = new DSU(n + 1);
        for (int[] edge : edges) {
            if (!dsu.union(edge[0], edge[1])) return edge;
        }
        return new int[] {};
    }
}
