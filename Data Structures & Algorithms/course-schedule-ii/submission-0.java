class Solution {

    private final Map<Integer, Set<Integer>> adjList = new HashMap<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // create adjcacency list
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int requirement = prerequisite[1];
            if (adjList.containsKey(course)) {
                adjList.get(course).add(requirement);
            } else {
                Set<Integer> list = new HashSet<>();
                list.add(requirement);
                adjList.put(course, list);
            }
        }

        // original no dependencies
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (!adjList.containsKey(i)) {
               queue.offer(i);
            }
        }

        List<Integer> topo = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (Map.Entry<Integer, Set<Integer>> entry : adjList.entrySet()) {
                int key = entry.getKey();
                Set<Integer> set = entry.getValue();
                if (set.remove(node) && set.isEmpty()) {
                    queue.add(key);
                }
            }
            topo.add(node);
        }

        if (topo.size() != numCourses) return new int[0];

        int[] ans = new int[numCourses];
        for (int i = 0; i < numCourses; i++) ans[i] = topo.get(i);
    
        return ans;
    }
}
