class Solution {
    public int trap(int[] heights) {

        int n = heights.length;

        int left = 0;
        int right = n - 1;
        int leftMax = heights[left];
        int rightMax = heights[right];
        int sum = 0;
        while (left < right) {
            if (leftMax < rightMax) { // left is bottle neck
                int water = leftMax - heights[left];
                if (water > 0) sum += water;
                left++;
                leftMax = Math.max(leftMax, heights[left]);
            } else {
                int water = rightMax - heights[right];
                if (water > 0) sum += water;
                right--;
                rightMax = Math.max(rightMax, heights[right]);
            }
        }

        return sum;
    }
}
