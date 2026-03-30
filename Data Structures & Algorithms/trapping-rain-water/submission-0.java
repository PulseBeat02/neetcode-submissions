class Solution {
    public int trap(int[] heights) {

        int max = -1;
        for (int height : heights) max = Math.max(max, height);

        int n = heights.length;
        boolean[][] elevations = new boolean[max][n];
        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            for (int j = 0; j < height; j++) {
                elevations[j][i] = true;
            }
        }

        int sum = 0;
        for (int i = max - 1; i >= 0; i--) { // count squares
            boolean foundBlack = false;
            int running = 0;
            for (int j = 0; j < n; j++) {
                if (elevations[i][j]) {
                    if (!foundBlack) foundBlack = true;
                    if (foundBlack) {
                        sum += running;
                        running = 0;
                    }
                } else {
                    if (foundBlack) running++;
                }
            }
        }

        return sum;
    }
}
