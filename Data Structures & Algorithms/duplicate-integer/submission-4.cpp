class Solution {
public:
    bool hasDuplicate(vector<int>& nums) {
        std::unordered_set<int> set;
        for (int num : nums) {
            if (std::find(set.begin(), set.end(), num) != set.end()) {
                return true;
            }
            set.insert(num);
        }
        return false;
    }
};