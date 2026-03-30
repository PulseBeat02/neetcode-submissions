class Solution {
    public int trap(int[] heights) {

        int n = heights.length;

        int[] leftMax = new int[n];
        leftMax[0] = heights[0];
        for (int i = 1; i < heights.length; i++) leftMax[i] = Math.max(leftMax[i - 1], heights[i]);

        int[] rightMax = new int[n];
        rightMax[n - 1] = heights[n - 1];
        for (int i = n - 2; i >= 0; i--) rightMax[i] = Math.max(rightMax[i + 1], heights[i]);

        int[] min = new int[n];
        for (int i = 0; i < n; i++) min[i] = Math.min(leftMax[i], rightMax[i]);

        int sum = 0;
        for (int i = 0; i < n; i++) {
            int water = min[i] - heights[i];
            if (water > 0) sum += water;
        }

        return sum;
    }
}
