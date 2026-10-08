class PrefixTree {

    public class TrieNode {
        public boolean end;
        public Map<Character, TrieNode> map;
        public TrieNode() {
            this.map = new HashMap<>();
        }
    }   
    
    TrieNode root;

    public PrefixTree() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
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
        char[] arr = word.toCharArray();
        TrieNode current = root;
        for (char c : arr) {
            if (current.map.containsKey(c)) {
                current = current.map.get(c);
                continue;
            }
            return false;
        }
        return current.end;
    }

    public boolean startsWith(String prefix) {
        char[] arr = prefix.toCharArray();
        TrieNode current = root;
        for (char c : arr) {
            if (current.map.containsKey(c)) {
                current = current.map.get(c);
                continue;
            }
            return false;
        }
        return true;
    }
}
