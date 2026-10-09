class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        int count = 0;
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (seen.contains(i)) continue;
            dfs(graph, seen, i);
            count++;
        }

        return count;
    }

    public void dfs(Map<Integer, List<Integer>> graph, Set<Integer> seen, int current) {
        if (seen.contains(current)) return;
        seen.add(current);
        List<Integer> neighbors = graph.getOrDefault(current, new ArrayList<>());
        for (int neighbor : neighbors) {
            dfs(graph, seen, neighbor);
        }
    }
}
