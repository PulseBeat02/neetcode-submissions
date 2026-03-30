class Solution {
public:
    bool isValid(string s) {
        unordered_map<char, char> map = {
            {')', '('},
            {'}', '{'},
            {']', '['}
        };

        stack<char> st;
        for (int i = 0; i < s.size(); i++) {
            if (map.count(s[i])) {
                if (st.empty() || map[s[i]] != st.top()) return false;
                st.pop();
            } else {
                st.push(s[i]);
            }
        }

        return st.empty();
    }
};
