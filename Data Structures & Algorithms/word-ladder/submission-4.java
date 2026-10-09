class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        Map<String, List<String>> graph = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            String current = wordList.get(i);
            List<String> neighbors = new ArrayList<>();
            for (String word : wordList) {
                if (word.equals(current)) continue;
                if (oneCharDiff(current, word)) neighbors.add(word);
            }
            graph.put(current, neighbors);
        }

        Set<String> seen = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (seen.contains(word)) continue;
                if (word.equals(endWord)) return steps + 1;
                seen.add(word);
                List<String> neighbors = graph.getOrDefault(word, new ArrayList<>());
                for (String neighbor : neighbors) {
                    queue.add(neighbor);
                }
            }
            steps++;
        }

        return 0;
    }

    public boolean oneCharDiff(String a, String b) {
        int n = a.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
                if (count > 1) return false;
            }
        }
        return count == 1;
    }
}
