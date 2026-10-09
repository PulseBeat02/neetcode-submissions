class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegrees = new int[n + 1];
        for (int[] edge : edges) {
            indegrees[edge[0]]++;
            indegrees[edge[1]]++;
            map.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indegrees[i] == 1) queue.add(i);
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            indegrees[node]--;
            List<Integer> neighbors = map.getOrDefault(node, new ArrayList<>());
            for (int neighbor : neighbors) {
                indegrees[neighbor]--;
                if (indegrees[neighbor] == 1) queue.add(neighbor);
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            int u = edges[i][0];
            int v = edges[i][1];
            if (indegrees[u] == 2 && indegrees[v] == 2) return new int[] {u, v};
        }

        return new int[0];
    }
}
