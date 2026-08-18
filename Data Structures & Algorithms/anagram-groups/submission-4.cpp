#include <functional>

class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> groups;
        for (string str : strs) {
            vector<int> freqs(26);
            for (char c : str) freqs[c - 'a']++;
            string res;
            for (int freq : freqs) {
                res += to_string(freq) + "#";
            }
            groups[res].push_back(str);
        }
        vector<vector<string>> vec;
        for (auto& [hash, group] : groups) {
            vec.push_back(group);
        }
        return vec;
    }
};
