class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int, int> map;
        for (int num : nums) map[num]++;

        struct Compare {
            bool operator()(const std::pair<int,int>& a,
                    const std::pair<int,int>& b) const {
                return a.second < b.second;   // min-heap by second
            }
        };

        priority_queue<pair<int, int>, std::vector<pair<int, int>>, Compare> pq;
        // num, freq
        for (auto it = map.begin(); it != map.end(); it++) {
            pq.push(make_pair(it->first, it->second));
        }

        vector<int> ans;
        for (int i = 0; i < k; i++) {
            pair<int, int> front = pq.top();
            pq.pop();
            ans.push_back(front.first);
        }

        return ans;
    }
};
