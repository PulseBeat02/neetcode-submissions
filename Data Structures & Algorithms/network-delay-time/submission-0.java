class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        Map<Integer, List<int[]>> adjList = new HashMap<>();
        for (int[] time : times) {
            int[] arr = { time[1], time[2] };
            if (adjList.containsKey(time[0])) {
                adjList.get(time[0]).add(arr);
            } else {
                List<int[]> list = new ArrayList<>();
                list.add(arr);
                adjList.put(time[0], list);
            }
        }

        Queue<int[]> heap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        heap.offer(new int[] {k, 0});

        Set<Integer> visited = new HashSet<>();
        int max = 0;
        while (!heap.isEmpty()) {

            int[] node = heap.poll();
            if (visited.contains(node[0])) continue;
            visited.add(node[0]);
            max = node[1];

            List<int[]> neighbors = adjList.get(node[0]);
            if (neighbors == null) continue;

            for (int[] neighbor : neighbors) {
                int child = neighbor[0];
                int weight = neighbor[1];
                if (!visited.contains(child)) {
                    heap.offer(new int[] {child, weight + node[1]});
                }
            }
        }

        return visited.size() == n ? max : -1;
    }
}
