class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {

        // value -> frequency
        unordered_map<int, int> freqs;
        for (int num : nums) freqs[num]++;

        // frequency -> list of values
        unordered_map<int, vector<int>> buckets;
        for (auto& [value, frequency] : freqs) {
            buckets[frequency].push_back(value);
        }

        vector<int> vec;
        for (int i = nums.size(); i >= 0; i--) {
            for (int val : buckets[i]) {
                if (vec.size() == k) return vec;
                vec.push_back(val);
            }
        }

        return vec;
    }
};
