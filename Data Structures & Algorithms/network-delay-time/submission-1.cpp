class Solution {
public:
    int networkDelayTime(vector<vector<int>>& times, int n, int k) {
        
        //            source -> neighbors(neighbor, weight)
        unordered_map<int, vector<pair<int, int>>> adjList;
        for (vector<int>& time : times) adjList[time[0]].push_back(make_pair(time[1], time[2]));

        struct Compare {
            bool operator()(pair<int, int> first, pair<int, int> second) {
                return first.second > second.second;
            }
        };

        unordered_set<int> visited;
        priority_queue<pair<int, int>, vector<pair<int, int>>, Compare> pq;
        pq.push(make_pair(k, 0)); // node, time

        int time = 0;
        while (!pq.empty()) {
            pair<int, int> p = pq.top();
            pq.pop();
            if (visited.count(p.first)) continue;
            visited.insert(p.first);
            time = p.second;
            for (pair<int, int>& neighbor : adjList[p.first]) {
                if (visited.count(neighbor.first)) continue;
                pair<int, int> create = make_pair(neighbor.first, neighbor.second + time);
                pq.push(create);
            }
        }

        return visited.size() == n ? time : -1;
    }
};
