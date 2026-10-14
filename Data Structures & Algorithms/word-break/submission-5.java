class Solution {

    class Trie {

        class TrieNode {
            Map<Character, TrieNode> map = new HashMap<>();
            boolean end;
         }

        TrieNode root;

        Trie() {
            this.root = new TrieNode();
        }

        public void addWord(String word) {
            TrieNode current = root;
            char[] chars = word.toCharArray();
            for (char c : chars) {
                if (current.map.containsKey(c)) {
                    current = current.map.get(c);
                } else {
                    TrieNode temp = new TrieNode();
                    current.map.put(c, temp);
                    current = temp;
                }
            }
            current.end = true;
        }

        public boolean startsWith(String word) {
            TrieNode current = root;
            char[] chars = word.toCharArray();
            for (char c : chars) {
                if (current.map.containsKey(c)) {
                    current = current.map.get(c);
                } else {
                    return false;
                }
            }
            return current.end;
        }
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();
        for (String word : wordDict) trie.addWord(word);
        return attempt(trie, wordDict, 0, s.length(), s);
    }

    Set<Integer> notPossible = new HashSet<>();

    public boolean attempt(Trie trie, List<String> wordDict, int s, int target, String current) {
        if (s == target) return true;
        if (s > target) return false;
        if (notPossible.contains(s)) return false;
        for (int i = s + 1; i <= target; i++) {
            String word = current.substring(s, i);
            if (trie.startsWith(word)) {
                if (attempt(trie, wordDict, s + word.length(), target, current)) return true;
            }
        }
        notPossible.add(s);
        return false;
    }
}





