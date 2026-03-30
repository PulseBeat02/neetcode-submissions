class Solution {
public:
    vector<string> findWords(vector<vector<char>>& board, vector<string>& words) {
        vector<string> ans;
        for (string& word : words) {
            if (search(board, word)) {
                ans.push_back(word);
            }
        }
        return ans;
    }

    bool search(vector<vector<char>>& board, string& word) {
        vector<vector<bool>> seen(board.size(), vector<bool>(board[0].size(), false));
        for (int r = 0; r < board.size(); r++) {
            for (int c = 0; c < board[r].size(); c++) {
                if (!backtrack(board, word, r, c, 0, seen)) continue;
                return true;
            }
        }
        return false;
    }

    bool backtrack(vector<vector<char>>& board, string& target, int r, int c, int index, vector<vector<bool>>& seen) {
        
        if ((r < 0 || r >= board.size()) || (c < 0 || c >= board[0].size())) return false;
        if (seen[r][c]) return false;
        if (board[r][c] != target[index]) return false;
        if (index == target.size() - 1) return true;

        seen[r][c] = true;
        bool result =
            backtrack(board, target, r + 1, c, index + 1, seen) ||
            backtrack(board, target, r - 1, c, index + 1, seen) ||
            backtrack(board, target, r, c + 1, index + 1, seen) ||
            backtrack(board, target, r, c - 1, index + 1, seen);
        seen[r][c] = false;

        return result;
    }
};
