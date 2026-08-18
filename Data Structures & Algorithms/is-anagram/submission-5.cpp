#include <cstring>

class Solution {
public:
    bool isAnagram(string s, string t) {
        int freqs[26] = { 0 };
        for (char c : s) freqs[c - 'a']++;
        int freqs1[26] = { 0 };
        for (char c : t) freqs1[c - 'a']++;
        return memcmp(freqs, freqs1, sizeof(freqs)) == 0;
    }
};
