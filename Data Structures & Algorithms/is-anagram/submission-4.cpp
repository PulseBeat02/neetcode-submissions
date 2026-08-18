class Solution {
public:
    bool isAnagram(string s, string t) {
        vector<int> freqs(26);
        for (char c : s) freqs[c - 'a']++;
        vector<int> freqs1(26);
        for (char c : t) freqs1[c - 'a']++;
        return freqs == freqs1;
    }
};
