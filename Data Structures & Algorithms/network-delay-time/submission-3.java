class Solution {
    public record Edge(int target, int time) {}
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Edge>> map = new HashMap<>();
        for (int[] time : times) {
            map.computeIfAbsent(time[0], c -> new ArrayList<>())
                .add(new Edge(time[1], time[2]));
        }

        Queue<Edge> queue = new PriorityQueue<>((a, b) -> {
            return a.time - b.time;
        });
        Set<Integer> visited = new HashSet<>();
        queue.add(new Edge(k, 0));
        int finalTime = 0;
        while (!queue.isEmpty()) {
            Edge edge = queue.poll();
            int node = edge.target;
            int time = edge.time;
            if (visited.contains(node)) continue;
            visited.add(node);
            finalTime = time;
            if (map.containsKey(node)) {
                for (Edge e : map.getOrDefault(node, new ArrayList<>())) {
                    int next = e.target;
                    int weight = e.time;
                    if (!visited.contains(next)) queue.add(new Edge(next, weight + time));
                }
            }
        }

        return visited.size() == n ? finalTime : -1;
    }
}
