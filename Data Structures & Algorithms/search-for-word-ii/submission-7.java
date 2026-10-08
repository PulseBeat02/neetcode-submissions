class Solution {

    public class WordDictionary {
        public class Node {
            boolean end;
            Map<Character, Node> map;
            Node() { map = new HashMap<>(); }
         }
         Node scrotum = new Node();
         void addWord(String word) {
            char[] arr = word.toCharArray();
            Node current = scrotum;
            for (char c : arr) {
                if (current.map.containsKey(c)) {
                    current = current.map.get(c);
                } else {
                    Node temp = new Node();
                    current.map.put(c, temp);
                    current = temp;
                }
            }
            current.end = true;
         }
    }

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> set = new HashSet<>();
        WordDictionary dih = new WordDictionary();
        for (String word : words) dih.addWord(word);
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] seen = new boolean[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (!dih.scrotum.map.containsKey(board[r][c])) continue;
                // next time, put conditions at beginning
                seen[r][c] = true;
                backtrack(set, dih.scrotum.map.get(board[r][c]), "" + board[r][c], r, c, board, seen);
                seen[r][c] = false;
            }
        }
        return new ArrayList<>(set);
    }

    public void backtrack(Set<String> set, WordDictionary.Node current, String word, int r, int c, char[][] board, boolean[][] seen) {
        if (current.end) {
            set.add(new String(word));
        } // keep going because words can contain other words (cap, capital)
        int[][] disp = new int[][] {
            {1, 0}, {0, 1}, {-1, 0}, {0, -1}
        };
        int rows = board.length;
        int cols = board[0].length;
        for (int[] d : disp) {
            int nR = r + d[0];
            int nC = c + d[1];
            if (nR < 0 || nR >= rows) continue;
            if (nC < 0 || nC >= cols) continue;
            char ch = board[nR][nC];
            if (!current.map.containsKey(ch)) continue;
            if (seen[nR][nC]) continue;
            seen[nR][nC] = true;
            backtrack(set, current.map.get(ch), word + ch, nR, nC, board, seen);
            seen[nR][nC] = false;
        }
    }
}












