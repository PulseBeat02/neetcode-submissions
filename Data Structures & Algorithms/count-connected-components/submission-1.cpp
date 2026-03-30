class Solution {
public:
    int countComponents(int n, vector<vector<int>>& edges) {
        unordered_map<int, vector<int>> adjList;
        for (vector<int>& edge : edges) {
            adjList[edge[0]].push_back(edge[1]);
            adjList[edge[1]].push_back(edge[0]);
        }

        vector<bool> seen(n, false);
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (seen[i]) continue;
            dfs(adjList, seen, i);
            count++;
        }

        return count;
    }

    void dfs(unordered_map<int, vector<int>>& adjList, vector<bool>& seen, int current) {
        if (seen[current]) return;
        seen[current] = true;
        for (int& neighbor : adjList[current]) {
            dfs(adjList, seen, neighbor);
        }
    }
};
