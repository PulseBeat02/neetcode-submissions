class Solution {
public:
    vector<vector<int>> kClosest(vector<vector<int>>& points, int k) {
        struct Compare {
            bool operator()(pair<int, int> first, pair<int, int> second) {
                return (first.first * first.first + first.second * first.second) >
                    (second.first * second.first + second.second * second.second);
            }
        };
        priority_queue<pair<int, int>, vector<pair<int, int>>, Compare> queue;
        for (vector<int>& point : points) queue.push({point[0], point[1]});

        vector<vector<int>> ans;
        for (int i = 0; i < k; i++) {
            pair<int, int> pair = queue.top();
            ans.push_back({pair.first, pair.second});
            queue.pop();
        }

        return ans;
    }
};
