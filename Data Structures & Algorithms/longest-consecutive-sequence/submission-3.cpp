class Solution {
public:
    int longestConsecutive(vector<int>& nums) {

        unordered_set<int> set;
        for (int num : nums) set.insert(num);

        int max = 0;
        for (int i = 0; i < nums.size(); i++) {
            int num = nums[i];
            if (!set.count(num - 1)) {
                int len = 0;
                while (set.count(num + len)) len++;
                max = std::max(max, len);
            }
        }
        return max;
    }
};
