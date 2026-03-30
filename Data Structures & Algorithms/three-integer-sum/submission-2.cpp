class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        set<vector<int>> vecs;
        for (int i = 0; i < nums.size(); i++) {
            int target = -nums[i];
            vector<vector<int>> res = twoSum(nums, target, i);
            for (vector<int> vec : res) {
                vector<int> tmp = {nums[i], nums[vec[0]], nums[vec[1]]};
                sort(tmp.begin(), tmp.end());
                vecs.insert(tmp);
            }
        }
        vector<vector<int>> ans;
        for (vector<int> vec : vecs) ans.push_back(vec);
        return ans;
    }

    vector<vector<int>> twoSum(vector<int> nums, int target, int exclude) {
        unordered_map<int, int> map;
        vector<vector<int>> vecs;
        for (int i = 0; i < nums.size(); i++) {
            if (i == exclude) continue;
            if (map.count(nums[i])) {
                vecs.push_back({map[nums[i]], i});
            }
            map[target - nums[i]] = i;
        }
        return vecs;
    }

};
