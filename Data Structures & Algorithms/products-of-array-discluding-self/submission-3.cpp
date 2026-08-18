class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {

        // O [1, 2, 4, 6]
        // P [1,  1,  2,  8, 48]
        // S [48, 48, 24, 6, 1 ]

        int n = nums.size();
        vector<int> prefix(n + 1);
        prefix[0] = 1;
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        
        vector<int> suffix(n + 1);
        suffix[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i];
        }

        vector<int> res(n);
        for (int i = 0; i < n; i++) {
            res[i] = prefix[i] * suffix[i + 1];
        }
        
        return res;
    }
};
