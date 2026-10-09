class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> courses = new HashMap<>();
        int[] indegrees = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            indegrees[prerequisite[0]]++;
            courses.computeIfAbsent(prerequisite[1], k -> new ArrayList<>())
                .add(prerequisite[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) queue.add(i);
        }

        int[] ordering = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            List<Integer> neighbors = courses.getOrDefault(course, new ArrayList<>());
            for (int neighbor : neighbors) {
                indegrees[neighbor]--;
                if (indegrees[neighbor] == 0) queue.add(neighbor);
            }
            ordering[index] = course;
            index++;
        }

        return index == numCourses ? ordering : new int[] {};
    }
}
