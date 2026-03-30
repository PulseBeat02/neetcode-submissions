class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < rows; i++) {
            set.add(i + ",0");
            set.add(i + "," + (cols - 1));
        }
        for (int i = 0; i < cols; i++) {
            set.add("0," + i);
            set.add((rows - 1) + "," + i);
        }
        System.out.println(set);
        for (String str : set) {
            String[] split = str.split(",");
            int r = Integer.parseInt(split[0]);
            int c = Integer.parseInt(split[1]);
            dfs(board, r, c);
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }

    int[][] directions = {
        {1, 0}, {-1, 0},
        {0, 1}, {0, -1}
    };

    public void dfs(char[][] board, int r, int c) {
        if (board[r][c] != 'O') return;
        board[r][c] = '#';
        for (int[] displacement : directions) {
            int nR = r + displacement[0];
            int nC = c + displacement[1];
            if (nR < 0 || nR >= board.length || nC < 0 || nC >= board[0].length) continue;
            if (board[nR][nC] != 'O') continue;
            dfs(board, nR, nC);
        }
    }
}
