class Solution {
    public boolean validTree(int n, int[][] edges) {
        // fully connected and n-1 edges
        if (edges.length != n - 1) return false;

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        connected(graph, visited, 0);

        return visited.size() == n;
    }

    public void connected(Map<Integer, List<Integer>> graph, Set<Integer> visited, int current) {
        if (visited.contains(current)) return;
        visited.add(current);
        List<Integer> neighbors = graph.getOrDefault(current, new ArrayList<>());
        for (int neighbor : neighbors) {
            connected(graph, visited, neighbor);
        }
    }
}
