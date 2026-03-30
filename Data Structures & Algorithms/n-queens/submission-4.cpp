class Solution {
public:
    vector<vector<string>> solveNQueens(int n) {
        vector<vector<char>> board(n, vector<char>(n, '.'));
        vector<vector<string>> ans;
        backtrack(board, ans, 0);
        return ans;
    }

    void backtrack(vector<vector<char>>& board, vector<vector<string>>& ans, int r) {
        if (r == board.size()) {
            vector<string> grid;
            for (vector<char>& line : board) {
                grid.push_back(string(line.begin(), line.end()));
            }
            ans.push_back(grid);
            return;
        }
        for (int c = 0; c < board.size(); c++) {
            if (!isValid(board, r, c)) {
                continue;
            }
            board[r][c] = 'Q';
            backtrack(board, ans, r + 1);
            board[r][c] = '.';
        }
    }

    bool isValid(vector<vector<char>>& board, int r, int c) {
        for (int i = 0; i < board.size(); i++) {
            if (board[r][i] == 'Q') return false;
        }

        for (int i = 0; i < board.size(); i++) {
            if (board[i][c] == 'Q') return false;
        }

        for (int radius = 0; radius < board.size(); radius++) {
            if (inBounds(board, r + radius, c + radius)) {
                if (board[r + radius][c + radius] == 'Q') return false;
            }
            if (inBounds(board, r - radius, c + radius)) {
                if (board[r - radius][c + radius] == 'Q') return false;
            }
            if (inBounds(board, r - radius, c - radius)) {
                if (board[r - radius][c - radius] == 'Q') return false;
            }
            if (inBounds(board, r + radius, c - radius)) {
                if (board[r + radius][c - radius] == 'Q') return false;
            }
        }

        return true;
    }

    bool inBounds(vector<vector<char>>& board, int r, int c) {
        return r >= 0 && r < board.size() && c >= 0 && c < board[0].size();
    }
};
