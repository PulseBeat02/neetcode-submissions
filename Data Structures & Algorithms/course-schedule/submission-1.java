class Solution {

    private final Map<Integer, List<Integer>> adjList = new HashMap<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // create adjcacency list
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int requirement = prerequisite[1];
            if (adjList.containsKey(course)) {
                adjList.get(course).add(requirement);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(requirement);
                adjList.put(course, list);
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (dfs(new HashSet<>(), i)) return false;
        }

        return true;
    }

    public boolean dfs(Set<Integer> visited, int current) {

        if (visited.contains(current)) {
            return true;
        }

        List<Integer> children = adjList.get(current);
        if (children == null) {
            return false;
        }

        visited.add(current);
        for (int requirement : children) {
            if (dfs(visited, requirement)) return true;
        }
        visited.remove(current);

        return false;
    }
}
