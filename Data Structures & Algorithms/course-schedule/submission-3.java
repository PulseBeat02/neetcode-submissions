class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        // course -> neighbors
        Map<Integer, List<Integer>> map = new HashMap<>();

        // course -> number of preqreqs
        int[] indegrees = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            indegrees[prerequisite[0]]++;
            map.computeIfAbsent(prerequisite[1], k -> new ArrayList<>())
                .add(prerequisite[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) queue.add(i);
        }

        int length = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            List<Integer> coursesTo = map.getOrDefault(node, new ArrayList<>());
            for (int course : coursesTo) {
                indegrees[course]--;
                if (indegrees[course] == 0) queue.add(course);
            }
            length++;
        }

        return length == numCourses;
    }
}
