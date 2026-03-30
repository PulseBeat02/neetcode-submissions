class Solution {
public:
    void islandsAndTreasure(vector<vector<int>>& grid) {
        int rows = grid.size();
        int cols = grid[0].size();
        queue<pair<int, int>> treasures;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 0) treasures.emplace(r, c);
            }
        }

        auto valid = [rows, cols](int r, int c) {
            if (r < 0 || r >= rows) return false;
            if (c < 0 || c >= cols) return false;
            return true;
        };

        int generation = 0;
        vector<vector<bool>> visited(rows, vector<bool>(cols, false));
        while (!treasures.empty()) {
            int size = treasures.size();
            for (int i = 0; i < size; i++) {
                auto [r, c] = treasures.front();
                treasures.pop();
                if (grid[r][c] == -1) continue;
                if (visited[r][c]) continue;
                grid[r][c] =generation;
                visited[r][c] = true;
                if (valid(r + 1, c)) treasures.emplace(r + 1, c);
                if (valid(r - 1, c)) treasures.emplace(r - 1, c);
                if (valid(r, c + 1)) treasures.emplace(r, c + 1);
                if (valid(r, c - 1)) treasures.emplace(r, c - 1);
            }
            generation++;
        }
    }
};
