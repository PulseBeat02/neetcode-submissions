class Solution {
public:
    string minWindow(string s, string t) {
        // expand window until requirements met for t
        int n = s.size();
        unordered_map<char, int> reqs;
        for (char c : t) reqs[c]++;

        string shortest;
        unordered_map<char, int> window;
        int left = 0;
        int min = INT_MAX;

        for (int right = 0; right < n; right++) {
            window[s[right]]++;
            if (!valid(reqs, window)) {
                continue;
            }
            while (valid(reqs, window)) {
                int len = right - left + 1;
                cout << s.substr(left, len) << endl;
                if (len < min) {
                    shortest = s.substr(left, len);
                    min = len;
                }
                window[s[left]]--;
                left++;
            }
        }

        return shortest;
    }

    bool valid(unordered_map<char, int>& reqs, unordered_map<char, int>& window) {
        for (auto it = reqs.begin(); it != reqs.end(); it++) {
            char match = it->first;
            int required = it->second;
            int current = window[match];
            if (current < required) {
                return false;
            }
        }
        return true;
    }
};
