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
            int u = find(a);
            int v = find(b);
            if (u == v) return false;
            // make v always smaller than u
            if (size[u] < size[v]) {
                int temp = u;
                u = v;
                v = temp;
            }
            parent[v] = u;
            size[u] += size[v];
            return true;
        }
    }

    record Edge(int start, int end, int distance) {}

    public int minCostConnectPoints(int[][] points) {

        Queue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(Edge::distance));

        int n = points.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int distance =
                    Math.abs(points[i][0] - points[j][0])
                    + Math.abs(points[i][1] - points[j][1]);
                queue.add(new Edge(i, j, distance));
            }
        }

        DSU dsu = new DSU(n);
        int cost = 0;
        int edges = 0;
        while (!queue.isEmpty() && edges < n) {
            Edge edge = queue.poll();
            if (dsu.union(edge.start, edge.end)) {
                cost += edge.distance;
                edges++;
            }

        }

        return cost;
    }
}










