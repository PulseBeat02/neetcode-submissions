class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {

        int rows = grid.size();
        int cols = grid[0].size();

        unordered_set<string> fresh;
        queue<string> rotten;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    fresh.insert(to_string(r) + " " + to_string(c));
                } else if (grid[r][c] == 2) {
                    rotten.push(to_string(r) + " " + to_string(c));
                }
            }
        }

        auto valid = [&grid, rows, cols](int r, int c) -> optional<string> {
            if (r < 0 || r >= rows) return nullopt;
            if (c < 0 || c >= cols) return nullopt;
            if (grid[r][c] != 1) return nullopt;
            grid[r][c] = 2;
            return to_string(r) + " " + to_string(c);
        };

        int generation = 0;
        while (!fresh.empty()) {
            if (rotten.empty()) {
                return -1;
            }
            int size = rotten.size();
            for (int i = 0; i < size; i++) {
                string input = rotten.front();
                rotten.pop();
                fresh.erase(input);
                stringstream ss(input);
                int r, c;
                ss >> r >> c;

                optional<string> first = valid(r + 1, c);
                optional<string> second = valid(r - 1, c);
                optional<string> third = valid(r, c + 1);
                optional<string> fourth = valid(r, c - 1);

                if (first) rotten.push(first.value());
                if (second) rotten.push(second.value());
                if (third) rotten.push(third.value());
                if (fourth) rotten.push(fourth.value());
            }
            generation++;
        }

        return generation - 1 >= 0 ? generation - 1 : 0;

    }
};
