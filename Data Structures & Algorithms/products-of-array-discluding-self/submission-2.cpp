class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {

        // original: [a, b, c, d]
        //   prefix: [1, a, a * b, a * b * c, a * b * c * d]
        //   suffix: [1, d, c * d, b * c * d, a * b * c * d]

        // [prefix[0] * suffix[3], prefix[1] * suffix[2], prefix[2] * suffix[1], prefix[3] * suffix[0]]

        int n = nums.size();

        // prefix
        int prefix[n+1];
        prefix[0] = 1;
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] * nums[i];
        } 

        // suffix
        int suffix[n+1];
        suffix[0] = 1;
        for (int i = 0; i < n; i++) {
            suffix[i + 1] = suffix[i] * nums[n - i - 1];
        }

        vector<int> ans;
        for (int i = 0; i < n; i++) {
            ans.push_back(prefix[i] * suffix[n - i - 1]);
        }

        return ans;

    }
};
