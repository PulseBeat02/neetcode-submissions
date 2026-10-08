class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) board[i] = ".".repeat(n).toCharArray();
        backtrack(ans, 0, board);
        return ans;
    }

    public void backtrack(List<List<String>> ans, int r, char[][] board) {
        if (r == board.length) {
            List<String> list = new ArrayList<>();
            for (char[] row : board) list.add(new String(row));
            ans.add(list);
            return;
        }
        for (int c = 0; c < board[0].length; c++) {
            if (isSafe(board, r, c)) {
                board[r][c] = 'Q';
                backtrack(ans, r + 1, board);
                board[r][c] = '.';
            }
        }
    }

    public boolean isSafe(char[][] board, int r, int c) {
        int n = board.length;

        // horizontal
        for (int nc = 0; nc < n; nc++) {
            if (board[r][nc] == 'Q') return false;
        }

        // vertical
        for (int nr = 0; nr < n; nr++) {
            if (board[nr][c] == 'Q') return false;
        }

        // top-left
        for (int nr = r, nc = c; nr >= 0 && nc >= 0; nr--, nc--) {
            if (board[nr][nc] == 'Q') return false;
        }

        // top-right
        for (int nr = r, nc = c; nr >= 0 && nc < n; nr--, nc++) {
            if (board[nr][nc] == 'Q') return false;
        }

        // bottom-left
        for (int nr = r, nc = c; nr < n && nc >= 0; nr++, nc--) {
            if (board[nr][nc] == 'Q') return false;
        }

        // bottom-right
        for (int nr = r, nc = c; nr < n && nc < n; nr++, nc++) {
            if (board[nr][nc] == 'Q') return false;
        }

        return true;
    }
}
