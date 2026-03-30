class WordDictionary {
public:

    struct Trie {
        bool word;
        unordered_map<char, Trie*> map;
        Trie() : word(false) {}
        Trie(bool w) : word(w) {} 
    };

    Trie root;

    WordDictionary() {
        
    }
    
    void addWord(string word) {
        Trie* current = &root;
        for (char c : word) {
            if (current->map.count(c)) {
                current = current->map[c];
            } else {
                Trie* node = new Trie(false);
                current->map[c] = node;
                current = node;
            }
        }
        current->word = true;
    }
    
    bool search(string word) {
        return match(&root, word, 0);
    }

    bool match(Trie* root, string word, int index) {
        if (index == word.size()) {
            return root->word;
        }
        if (word[index] == '.') {
            bool found = false;
            for (auto it = root->map.begin(); it != root->map.end(); it++) {
                found = found || match(it->second, word, index + 1);
            }
            return found;
        }
        if (!root->map.contains(word[index])) {
            return false;
        }
        return match(root->map[word[index]], word, index + 1);
    }
};
