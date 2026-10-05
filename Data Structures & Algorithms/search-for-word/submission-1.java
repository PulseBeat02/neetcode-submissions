class Solution {

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] seen = new boolean[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (dfs(board, seen, r, c, 0, word)) return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, boolean[][] seen, int i, int j, int index, String word) {
        if (index == word.length()) return true;

        int rows = board.length;
        int cols = board[0].length;
        if (i < 0 || i >= rows || j < 0 || j >= cols) return false;
        if (seen[i][j]) return false;
        if (word.charAt(index) != board[i][j]) return false;

        seen[i][j] = true;
        boolean res = dfs(board, seen, i + 1, j, index + 1, word)
            || dfs(board, seen, i, j + 1, index + 1, word)
            || dfs(board, seen, i - 1, j, index + 1, word)
            || dfs(board, seen, i, j - 1, index + 1, word);
        seen[i][j] = false;
        
        return res;
    }
}
