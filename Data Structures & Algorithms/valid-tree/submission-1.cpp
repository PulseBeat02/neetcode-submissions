class Solution {
public:
    bool validTree(int n, vector<vector<int>>& edges) {

        if (edges.size() != n - 1) return false;

        unordered_map<int, vector<int>> adjList;
        for (vector<int>& edge : edges) {
            int first = edge[0];
            int second = edge[1];
            adjList[first].push_back(second);
            adjList[second].push_back(first);
        }

        for (int i = 0; i < n; i++) {
            unordered_set<int> seen;
            check(adjList, seen, i);
            if (seen.size() == n) return true;
        }

        return false;
    }

    void check(unordered_map<int, vector<int>>& adjList, unordered_set<int>& seen, int& current) {
        if (seen.count(current)) return;
        seen.insert(current);
        for (int& neighbor : adjList[current]) {
            check(adjList, seen, neighbor);
        }
    }
};
