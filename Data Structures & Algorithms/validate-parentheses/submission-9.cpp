class Solution {
public:
    bool isValid(string s) {
        stack<char> stacks;
        unordered_map<char, char> mapping;
        mapping['('] = ')';
        mapping['['] = ']';
        mapping['{'] = '}';
        for (char& c : s) {
            if (c == '[' || c == '(' || c == '{') {
                stacks.push(c);
            } else {
                if (stacks.empty()) return false;
                char top = stacks.top();
                stacks.pop();
                if (mapping[top] != c) return false;
            }
        }
        return stacks.empty();
    }
};
