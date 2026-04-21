class Solution {
    public int trap(int[] height) {

        int n = height.length;

        int left = 0;
        int right = n - 1;
        int maxLeft = height[left];
        int maxRight = height[right];
        int sum = 0;
        while (left < right) {
            if (maxLeft < maxRight) {
                int units = maxLeft - height[left];
                if (units > 0) sum += units;
                left++;
                maxLeft = Math.max(maxLeft, height[left]);
            } else {
                int units = maxRight - height[right];
                if (units > 0) sum += units;
                right--;
                maxRight = Math.max(maxRight, height[right]);
            }
        }

        return sum;
    }
}