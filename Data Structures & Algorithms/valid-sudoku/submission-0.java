class Solution {
    public boolean isValidSudoku(char[][] board) {

        // ROW CHECK
        for (char[] row : board) {
            Set<Character> set = new HashSet<>();
            for (char c : row) {
                if (c == '.') continue;
                if (set.contains(c)) return false;
                set.add(c);
            }
        }

        // COLUMN CHECK
        for (int j = 0; j < board[0].length; j++) {
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < board.length; i++) {
                if (board[i][j] == '.') continue;
                if (set.contains(board[i][j])) return false;
                set.add(board[i][j]);
            }
        }

        // SQUARES CHECK
        Map<String, Set<Character>> maps = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') continue;
                int r = i / 3;
                int c = j / 3;
                String hash = r + "#" + c;
                if (maps.containsKey(hash)) {
                    if (maps.get(hash).contains(board[i][j])) return false;
                } else {
                    Set<Character> set = new HashSet<>();
                    set.add(board[i][j]);
                    maps.put(hash, set);
                }
            }
        }

        return true;
    }
}
