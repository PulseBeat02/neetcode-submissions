class Solution {
public:
    int maxArea(vector<int>& heights) {
        int n = heights.size();
        int left = 0;
        int right = n - 1;
        int ans = 0;
        while (left < right) {
            int leftHeight = heights[left];
            int rightHeight = heights[right];
            int area = (right - left) * min(leftHeight, rightHeight);
            ans = max(area, ans);
            if (leftHeight < rightHeight) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
};
