class Solution {
public:
    int trap(vector<int>& height) {
        // O: [0, 2, 0, 3, 1, 0, 1, 3, 2, 1]
        // L: [0, 2, 2, 3, 3, 3, 3, 3, 3, 3]
        // R: [3, 3, 3, 3, 3, 3, 3, 3, 2, 1]
        // M: [0, 2, 2, 3, 3, 3, 3, 3, 2, 1]
        // A: [0, 0, 2, 0, 2, 3, 2, 0, 0, 0]
        int n = height.size();
        int left[n];
        left[0] = height[0];
        for (int i = 1; i < n; i++) {
            left[i] = max(left[i - 1], height[i]);
        }

        int right[n];
        right[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = max(right[i + 1], height[i]);
        }

        int minOfMaxes[n];
        for (int i = 0; i < n; i++) {
            minOfMaxes[i] = min(left[i], right[i]);
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            int water = minOfMaxes[i] - height[i];
            if (water > 0) sum += water;
        }

        return sum;
    }
};
