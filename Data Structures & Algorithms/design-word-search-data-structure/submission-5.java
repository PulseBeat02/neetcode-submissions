class WordDictionary {

    public class TrieNode {
        public Map<Character, TrieNode> map;
        public boolean end;
        public TrieNode() {
            map = new HashMap<>();
        }
    }

    TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        char[] arr = word.toCharArray();
        TrieNode current = root;
        for (char c : arr) {
            if (current.map.containsKey(c)) {
                current = current.map.get(c);
                continue;
            } else {
                TrieNode temp = new TrieNode();
                current.map.put(c, temp);
                current = temp;
            }
        }
        current.end = true;
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }

    public boolean search(String word, int i, TrieNode current) {
        char[] arr = word.toCharArray();
        for (; i < arr.length; i++) {
            char c = arr[i];
            if (current.map.containsKey(c)) {
                current = current.map.get(c);
                continue;
            } else if (c == '.') {
                for (TrieNode next : current.map.values()) {
                    if (search(word, i + 1, next)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return current.end;
    }
}
