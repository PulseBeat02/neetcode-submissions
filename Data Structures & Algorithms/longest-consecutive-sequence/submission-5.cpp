class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        unordered_set<int> sequence;
        for (int& num : nums) sequence.insert(num);

        int max = 0;
        for (int i = 0; i < nums.size(); i++) {
            int current = nums[i];
            if (!sequence.contains(current - 1)) {
                int len = 1;
                while (sequence.contains(current + len)) len++;
                max = std::max(max, len);
            }
        }

        return max;
    }
};
