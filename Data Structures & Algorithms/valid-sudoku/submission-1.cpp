class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {

        // row
        for (vector<char> row : board) {
            unordered_set<char> set;
            for (char c : row) {
                if (c == '.') continue;
                if (set.count(c)) {
                    return false;
                }
                set.insert(c);
            }
        }

        // col
        for (int j = 0; j < board[0].size(); j++) {
            unordered_set<char> set;
            for (int i = 0; i < board.size(); i++) {
                char c = board[i][j];
                if (c == '.') continue;
                if (set.count(c)) {
                    return false;
                }
                set.insert(c);
            }
        }

        // squares
        unordered_map<string, unordered_set<char>> map;
        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board[i].size(); j++) {
                char elem = board[i][j];
                if (elem == '.') continue;
                int r = i / 3;
                int c = j / 3;
                string key = to_string(r) + ":" + to_string(c);
                if (map[key].count(elem)) {
                    return false;
                }
                map[key].insert(elem);
            }
        }
        
        return true;
    }
};
