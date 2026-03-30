class Solution {
public List<Integer> spiralOrder(int[][] matrix) {
    int m = matrix.length, n = matrix[0].length;
    List<Integer> res = new ArrayList<>(m * n);
    boolean[][] vis = new boolean[m][n];
    int[] dr = {0, 1, 0, -1};
    int[] dc = {1, 0, -1, 0};
    int r = 0, c = 0, dir = 0;
    for (int k = 0; k < m * n; k++) {
        res.add(matrix[r][c]);
        vis[r][c] = true;
        int nr = r + dr[dir], nc = c + dc[dir];
        if (nr < 0 || nr >= m || nc < 0 || nc >= n || vis[nr][nc]) {
            dir = (dir + 1) % 4;
            nr = r + dr[dir];
            nc = c + dc[dir];
        }
        r = nr; c = nc;
    }
    return res;
}

}
