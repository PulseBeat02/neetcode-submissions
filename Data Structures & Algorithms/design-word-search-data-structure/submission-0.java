class WordDictionary {

    class TrieNode {
        public Map<Character, TrieNode> children = new HashMap<>();
        public boolean last;
    }

    TrieNode root = new TrieNode();

    public void addWord(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            current = current.children.computeIfAbsent(c, k -> new TrieNode());
        }
        current.last = true;
    }

    public boolean searchTrie(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            if (!current.children.containsKey(c)) {
                return false;
            }
            current = current.children.get(c);
        }
        return current.last;
    }

    public boolean isPrefix(String prefix) {
        TrieNode current = root;
        for (char c : prefix.toCharArray()) {
            if (!current.children.containsKey(c)) {
                return false;
            }
            current = current.children.get(c);
        }
        return true;
    }

    public boolean search(String word) {
        return search0(word, 0, root);
    }

    public boolean search0(String word, int i, TrieNode current) {
        if (current == null) return false;
        if (i == word.length()) return current.last;
        char c = word.charAt(i);
        if (c == '.') {
            for (TrieNode child : current.children.values()) {
                if (search0(word, i + 1, child)) return true;
            }
            return false;
        } else {
            return search0(word, i + 1, current.children.get(c));
        }
    }
}
