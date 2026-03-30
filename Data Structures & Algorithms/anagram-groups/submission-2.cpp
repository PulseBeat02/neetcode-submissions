class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> map;
        for (string str : strs) {
            int first[26] = {0};
            for (char c : str) {
                first[c - 'a']++;
            }
            string key;
            for (int i = 0; i < 26; i++) {
                key += (to_string(i) + "=" + to_string(first[i]));
            }
            if (map.count(key)) {
                map[key].push_back(str);
            } else {
                vector<string> vec;
                vec.push_back(str);
                map[key] = vec;
            }
        }
        vector<vector<string>> vecs;
        for (auto it = map.begin(); it != map.end(); it++) {
            vecs.push_back(it->second);
        }
        return vecs;
    }
};
