class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {

        int rows = board.size();
        int cols = board[0].size();

        // rows
        for (int r = 0; r < rows; r++) {
            unordered_set<char> dupes;
            for (char current : board[r]) {
                if (current == '.') continue;
                if (dupes.contains(current)) return false;
                dupes.insert(current);
            }
        }

        // cols
        for (int c = 0; c < cols; c++) {
            unordered_set<char> dupes;
            for (int r = 0; r < rows; r++) {
                char current = board[r][c];
                if (current == '.') continue;
                if (dupes.contains(current)) return false;
                dupes.insert(current);
            }
        }

        // boxes
        // [r, c] => [#, #...]
        unordered_map<string, unordered_set<char>> dupes;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                char current = board[r][c];
                if (current == '.') continue;

                string key = to_string(r / 3) + to_string(c / 3);
                if (dupes[key].contains(current)) return false;
                dupes[key].insert(current);
            }
        }

        return true;
    }
};
