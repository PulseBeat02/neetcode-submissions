class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Map<String, Set<String>> graph = new HashMap<>();

        List<String> words = new ArrayList<>(wordList);
        words.add(beginWord);

        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                char[] arr = word.toCharArray();
                arr[i] = '*';
                String res = new String(arr);
                if (graph.containsKey(res)) {
                    graph.get(res).add(word);
                } else {
                    Set<String> set = new HashSet<>();
                    set.add(word);
                    graph.put(res, set);
                }
            }
        }

        Map<String, Set<String>> adjList = new HashMap<>();
        for (String key : graph.keySet()) {
            Set<String> connected = graph.get(key);
            Set<String> copy = new HashSet<>(connected);
            for (String node : connected) {
                if (!adjList.containsKey(node)) {
                    adjList.put(node, new HashSet<>());
                }
                Set<String> neighbors = adjList.get(node);
                for (String n : copy) {
                    if (!n.equals(node)) {
                        neighbors.add(n);
                    }
                }
            }
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        Set<String> visited = new HashSet<>();
        int count = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String node = queue.poll();
                if (node.equals(endWord)) {
                    return count;
                }

                if (visited.contains(node)) {
                    continue;
                }
                visited.add(node);

                Set<String> list = adjList.get(node);
                for (String child : list) {
                    queue.offer(child);
                }
            }
            count++;
        }

        return 0;
    }
}
