class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> adjList = new HashMap<>();
        Map<Character, Integer> indegrees = new HashMap<>();
        int n = words.length;
        for (String word : words) {
            for (char c : word.toCharArray()) {
                indegrees.putIfAbsent(c, 0);
            }
        }
        for (int i = 0; i < n - 1; i++) {
            String first = words[i];
            String second = words[i + 1];
            int min = Math.min(first.length(), second.length());
            if (first.length() > second.length()
                    && first.startsWith(second)) {
                return "";
            }
            for (int j = 0; j < min; j++) {
                char firstC = first.charAt(j);
                char secondC = second.charAt(j);
                if (firstC == secondC) continue;
                if (adjList.computeIfAbsent(firstC, k -> new HashSet<>()).add(secondC)) {
                    indegrees.put(secondC, indegrees.getOrDefault(secondC, 0) + 1);
                }
                break;
            }
        }

        Queue<Character> queue = new LinkedList<>();
        for (Map.Entry<Character, Integer> entry : indegrees.entrySet()) {
            if (entry.getValue() == 0) queue.add(entry.getKey());
        }

        String alphabet = "";
        while (!queue.isEmpty()) {
            char first = queue.poll();
            alphabet += first;
            Set<Character> neighbors = adjList.getOrDefault(first, new HashSet<>());
            for (char neighbor : neighbors) {
                indegrees.put(neighbor, indegrees.get(neighbor) - 1);
                if (indegrees.get(neighbor) == 0) queue.add(neighbor);
            }
        }

        if (alphabet.length() != indegrees.size()) {
            return "";
        }


        return alphabet.toString();
    }
}
