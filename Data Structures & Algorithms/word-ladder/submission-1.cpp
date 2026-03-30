class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {

        wordList.push_back(beginWord);
        unordered_map<string, vector<string>> common;
        for (string& word : wordList) {
            for (int i = 0; i < word.size(); i++) {
                string copy = string(word);
                copy[i] = '*';
                common[copy].push_back(word);
            }
        }

        unordered_map<string, vector<string>> adjList;
        for (auto it = common.begin(); it != common.end(); it++) {
            vector<string> value = it->second;
            for (string& node : value) {
                vector<string> copy = vector<string>(value);
                auto it = std::find(copy.begin(), copy.end(), node);
                if (it != copy.end()) {
                    copy.erase(it);
                }
                adjList[node].insert(adjList[node].end(), copy.begin(), copy.end());
            }
        }

        queue<string> queue;
        unordered_set<string> seen;
        queue.push(beginWord);
        int iterations = 1;
        while (!queue.empty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                string word = queue.front();
                queue.pop();
                if (word == endWord) {
                    return iterations;
                }
                seen.insert(word);
                for (string& neighbor : adjList[word]) {
                    if (seen.count(neighbor)) continue;
                    queue.push(neighbor);
                }
            }
            iterations++;
        }

        return 0;
    }
};
