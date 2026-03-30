class Solution {
    public boolean exist(char[][] board, String word) {
        char check = word.charAt(0);
        boolean[][] arr = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, word, arr, i, j, 0)) return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, boolean[][] visited, int r, int c, int length) {
        
        if (length == word.length()) return true;
        if (!isValid(board, r, c)) return false;
        if (visited[r][c]) return false;
        if (board[r][c] != word.charAt(length)) return false;

        visited[r][c] = true;

        boolean found = dfs(board, word, visited, r + 1, c, length + 1)
            || dfs(board, word, visited, r - 1, c, length + 1)
            || dfs(board, word, visited, r, c + 1, length + 1)
            || dfs(board, word, visited, r, c - 1, length + 1);

        visited[r][c] = false;

        return found;
    }

    public boolean isValid(char[][] board, int r, int c) {
        return r >= 0 && r < board.length && c >= 0 && c < board[0].length;
    }
}
