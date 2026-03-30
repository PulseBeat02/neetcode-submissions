class Solution {

    private final Set<String> pacific = new HashSet<>();
    private final Set<String> atlantic = new HashSet<>();
    private final int[][] directions = {
        {1, 0}, {-1, 0},
        {0, 1}, {0, -1}
    };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        for (int i = 0; i < rows; i++) {
            pacific.add(i + ",0");
            atlantic.add(i + "," + (cols - 1));
        }
        for (int i = 0; i < cols; i++) {
            pacific.add(0 + "," + i);
            atlantic.add((rows - 1) + "," + i);
        }
        Set<String> pacificCommon = new HashSet<>(pacific);
        for (String str : pacific) {
            String[] split = str.split(",");
            int r = Integer.parseInt(split[0]);
            int c = Integer.parseInt(split[1]);
            dfs(pacificCommon, r, c, heights);
        }
        Set<String> atlanticCommon = new HashSet<>(atlantic);
        for (String str : atlantic) {
            String[] split = str.split(",");
            int r = Integer.parseInt(split[0]);
            int c = Integer.parseInt(split[1]);
            dfs(atlanticCommon, r, c, heights);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (String str : pacificCommon) {
            if (atlanticCommon.contains(str)) {
                String[] split = str.split(",");
                int r = Integer.parseInt(split[0]);
                int c = Integer.parseInt(split[1]);
                ans.add(List.of(r, c));
            }
        }
        return ans;
    }

    public void dfs(Set<String> visited, int r, int c, int[][] heights) {

        String hash = r + "," + c;
        visited.add(hash);

        for (int[] displacement : directions) {
            int nR = r + displacement[0];
            int nC = c + displacement[1];
            if (nR < 0 || nR >= heights.length || nC < 0 || nC >= heights[0].length) continue;
            if (visited.contains(nR + "," + nC)) continue;
            if (heights[nR][nC] < heights[r][c]) continue;
            dfs(visited, nR, nC, heights);
        }
    }


}
