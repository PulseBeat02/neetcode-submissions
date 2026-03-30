class PrefixTree {
public:

    struct Trie {
        unordered_map<char, Trie*> map;
        bool word;
        Trie() : word(false) {}
        Trie(bool w) : word(w) {}
    };

    Trie root;

    PrefixTree() : root(false) {
    }

    ~PrefixTree() {
        freeTrie(&root);
    }

    void freeTrie(Trie* trie) {
        for (auto it = trie->map.begin(); it != trie->map.end(); it++) {
            freeTrie(it->second);
            delete it->second;
        }
    }
    
    void insert(string word) {
        Trie* current = &root;
        for (char c : word) {
            if (!current->map.count(c)) {
                Trie* create = new Trie(false);
                current->map[c] = create;
                current = create;
            } else {
                current = current->map[c];
            }
        }
        current->word = true;
    }
    
    bool search(string word) {
        Trie* current = &root;
        for (char c : word) {
            if (!current->map.count(c)) {
                return false;
            }
            current = current->map[c];
        }
        return current->word;
    }
    
    bool startsWith(string prefix) {
        Trie* current = &root;
        for (char c : prefix) {
            if (!current->map.count(c)) {
                return false;
            }
            current = current->map[c];
        }
        return true;
    }
};
