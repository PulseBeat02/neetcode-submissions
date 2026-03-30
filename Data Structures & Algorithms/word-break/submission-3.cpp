class Solution {
public:

    bool wordBreak(string s, vector<string>& wordDict) {
        string str = "";
        vector<int> dp(s.size() + 1, -1);
        return valid(dp, wordDict, 0, s);
    }

    bool valid(vector<int>& dp, vector<string>& words, int index, string& target) {
        if (index == target.size()) return true;
        if (dp[index] != -1) return dp[index];
        for (string& str : words) {

            string substr = target.substr(index);
            if (str.size() > substr.size()) continue;

            bool allowed = true;
            for (int i = 0; i < str.size(); i++) {
                if (substr[i] != str[i]) {
                    allowed = false;
                    break;
                }
            }
            if (!allowed) continue;
            if (!valid(dp, words, index + str.size(), target)) continue;
            dp[index] = 1;
            return true;
        }
        dp[index] = 0;
        return false;
    }
};
