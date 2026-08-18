class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        vector<vector<int>> ans;
        for (int i = 0; i < nums.size(); i++) {
            int target = -nums[i];
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            vector<vector<int>> curr = twoSum(nums, target, i + 1);
            for (vector<int>& vec : curr) {
                vec.push_back(nums[i]);
                ans.push_back(vec);
            }
        }
        return ans;
    }

    vector<vector<int>> twoSum(vector<int>& nums, int target, int start) {
        vector<vector<int>> ans;
        unordered_map<int, int> map;
        for (int i = start; i < nums.size(); i++) {
            int current = nums[i];
            if (map.count(current)) {
                ans.push_back({nums[map[current]], current});
                while (i + 1 < nums.size() && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
            map[target - current] = i;
        }
        return ans;
    }
};
