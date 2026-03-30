class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        std::unordered_map<int, int> map;
        for (int i = 0; i < nums.size(); i++) {
            if (map.count(nums[i])) {
                vector<int> res;
                res.push_back(map[nums[i]]);
                res.push_back(i);
                return res;
            }
            map[target - nums[i]] = i;
        }
    }
};
