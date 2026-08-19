class Solution {
public:
    int trap(vector<int>& height) {
        // O: [0, 2, 0, 3, 1, 0, 1, 3, 2, 1]
        // L: [0, 2, 2, 3, 3, 3, 3, 3, 3, 3]
        // R: [3, 3, 3, 3, 3, 3, 3, 3, 2, 1]
        // M: [0, 2, 2, 3, 3, 3, 3, 3, 2, 1]
        // A: [0, 0, 2, 0, 2, 3, 2, 0, 0, 0]
        int n = height.size();
        int left = 0;
        int right = n - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        int sum = 0;
        while (left < right) {
            if (leftMax < rightMax) {
                int water = leftMax - height[left];
                if (water > 0) sum += water;
                left++;
                leftMax = max(leftMax, height[left]);
            } else {
                int water = rightMax - height[right];
                if (water > 0) sum += water;
                right--;
                rightMax = max(rightMax, height[right]);
            }
        }
        return sum;
    }
};
