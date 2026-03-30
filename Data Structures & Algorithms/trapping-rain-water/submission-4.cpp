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
            if (leftMax < rightMax) {
                int water = leftMax - height[left];
                if (water >= 0) sum += water;
                left++;
                leftMax = max(leftMax, height[left]);
            } else {
                int water = rightMax - height[right];
                if (water >= 0) sum += water;
                right--;
                rightMax = max(rightMax, height[right]);
            }
        }
        return sum;
    }
};
