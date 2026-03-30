class Solution {
public:
    int numDecodings(string s) {
        return count(s, 0);
    }

    int count(string& str, int index) {
        if (index == str.size()) return 1;
        if (str[index] == '0') return 0; // first iteration
        int ans = 0;
        int n = str.size();
        ans += count(str, index + 1); 
        if (index + 1 < n) {
            int val = (str[index] - '0') * 10 + (str[index + 1] - '0');
            if (val >= 10 && val <= 26) ans += count(str, index + 2);
        }
        return ans;
    }
};
