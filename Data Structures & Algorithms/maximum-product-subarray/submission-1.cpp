class Solution {
public:
int maxProduct(vector<int>& nums) {
    int curMax = nums[0];
    int curMin = nums[0];
    int ans = nums[0];
    for (int i = 1; i < nums.size(); i++) {
        int x = nums[i];
        if (x < 0) swap(curMax, curMin);  // sign flip
        curMax = std::max(x, curMax * x);
        curMin = std::min(x, curMin * x);
        ans = std::max(ans, curMax);
    }
    return ans;
}
};
