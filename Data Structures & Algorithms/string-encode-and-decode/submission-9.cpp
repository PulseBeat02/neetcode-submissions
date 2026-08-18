class Solution {
public:

    // length # string

    string encode(vector<string>& strs) {
        string res;
        for (string str : strs) {
            int len = str.length();
            res += (to_string(len) + "#" + str);
        }
        return res;
    }

    // 5#hello..

    vector<string> decode(string s) {
        vector<string> ans;
        string num;
        for (int i = 0; i < s.length(); i++) {
            char current = s[i];
            if (current == '#') {
                int len = stoi(num);
                ans.push_back(s.substr(i + 1, len));
                i += len;
                num = "";
            } else {
                num += current;
            }
        }
        return ans;
    }
};
