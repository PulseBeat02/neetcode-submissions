class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> map;
        for (int i = 0; i < nums.size(); i++) {
            int num = nums[i];
            auto it = map.find(num);
            if (it != map.end()) {
                return {it->second, i};
            }
            map[target - num] = i;
        }
        return {};
    }
};
