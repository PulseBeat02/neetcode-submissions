class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        unordered_map<int, vector<int>> adjList;
        for (vector<int>& pair : prerequisites) {
            int target = pair[0];
            int dep = pair[1];
            adjList[dep].push_back(target);
        }

        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(adjList, {}, i)) return false;
        }

        return true;
    }

    bool hasCycle(unordered_map<int, vector<int>>& adjList, unordered_set<int> seen, int current) {
        if (seen.count(current)) return true;
        vector<int> neighbors = adjList[current];
        seen.insert(current);

        for (int& neighbor : neighbors) {
            if (hasCycle(adjList, seen, neighbor)) return true;
        }

        return false;
    }
};
