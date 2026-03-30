class Solution {
public:

    string encode(vector<string>& strs) {
        if (strs.size() == 0) return "";
        string res;
        for (string str : strs) {
            res += to_string(str.size());
            res += "#";
            res += str;
        }
        cout << res << endl;
        return res;
    }

    // 1#e2#dd

    vector<string> decode(string s) {
        vector<string> vec;
        int i = 0;
        while (i < (int)s.size()) {
            int start = i; 

            while (s[i] != '#') {
                i++;
            }

            int size = stoi(s.substr(start, i - start));
            i++;

            vec.push_back(s.substr(i, size));
            i += size;
        }
        return vec;
    }
};
