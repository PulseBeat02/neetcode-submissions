class Solution {
public:
    int trap(vector<int>& height) {
        int n = height.size();
        int left = 0;
        int right = n - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        int sum = 0;
        while (left <= right) {
            if (height[left] < rightMax) {
                int water = leftMax - height[left];
                if (water > 0) sum += water;
                leftMax = max(leftMax, height[left]);
                left++;
            } else {
                int water = rightMax - height[right];
                if (water > 0) sum += water;
                rightMax = max(rightMax, height[right]);
                right--;
            }
        }
        return sum;
    }
};
