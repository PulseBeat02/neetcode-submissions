class Solution {
    public int trap(int[] height) {


        // 0 2 0 3 1 0 1 3 2 1
        
        // 0 2 2 3 3 3 3 3 3 3 (max from left)
        // 3 3 3 3 3 3 3 3 2 1 (max from right)

        // 0 2 2 3 3 3 3 3 2 1 (mins)
        // 0 0 2 0 2 3 2 0 0 0 (water)

        int n = height.length;
        int left = 0;
        int right = n - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        int sum = 0;
        while (left <= right) {
            if (leftMax < rightMax) {
                int water = leftMax - height[left];
                if (water > 0) sum += water;
                leftMax = Math.max(height[left], leftMax);
                left++;
            } else {
                int water = rightMax - height[right];
                if (water > 0) sum += water;
                rightMax = Math.max(height[right], rightMax);
                right--;
            }
        }

        return sum;

    }
}
