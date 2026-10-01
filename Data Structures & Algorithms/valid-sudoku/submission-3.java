class Solution {
    public boolean isValidSudoku(char[][] board) {
        return checkRows(board) && checkCols(board) && checkBoxes(board);
    }

    public boolean checkBoxes(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        Map<Integer, Set<Character>> boxes = new HashMap<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                char character = board[r][c];
                if (character == '.') continue;
                int hash = Arrays.hashCode(new int[] {r/3, c/3});
                if (boxes.containsKey(hash)) {
                    Set<Character> box = boxes.get(hash);
                    if (box.contains(character)) return false;
                    box.add(character);
                } else {
                    Set<Character> box = new HashSet<>();
                    box.add(character);
                    boxes.put(hash, box);
                }
            }
        }
        return true;
    }

    public boolean checkCols(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        for (int col = 0; col < cols; col++) {
            Set<Character> seen = new HashSet<>();
            for (int row = 0; row < rows; row++) {
                char character = board[row][col];
                if (character == '.') continue;
                if (seen.contains(character)) return false;
                seen.add(character);
            }
        }
        return true;
    }

    public boolean checkRows(char[][] board) {
        for (char[] row : board) {
            Set<Character> seen = new HashSet<>();
            for (char c : row) {
                if (c == '.') continue;
                if (seen.contains(c)) return false;
                seen.add(c);
            }
        }
        return true;
    }
}
