class Solution {
public:
    vector<int> findRedundantConnection(vector<vector<int>>& edges) {

        int n = edges.size();
        unordered_map<int, vector<int>> adjList;
        vector<int> indegrees(n + 1, 0); // source -> dest
        for (vector<int>& edge : edges) {
            indegrees[edge[1]]++;
            indegrees[edge[0]]++;
            adjList[edge[0]].push_back(edge[1]);
            adjList[edge[1]].push_back(edge[0]);
        }

        queue<int> q;
        for (int i = 1; i <= n; i++) {
            if (indegrees[i] == 1) q.push(i);
        }

        while (!q.empty()) {
            int top = q.front();
            q.pop();
            indegrees[top]--;
            for (int children : adjList[top]) {
                indegrees[children]--;
                if (indegrees[children] == 1) q.push(children);
            }
        }

        for (auto it = edges.rbegin(); it != edges.rend(); it++) {
            vector<int>& edge = *it;
            if (indegrees[edge[0]] > 0 && indegrees[edge[1]] > 0) {
                return {edge[0], edge[1]};
            }
        }

        return {};
    }
};
