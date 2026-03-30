class Solution {
public:
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        
        unordered_map<int, int> indegrees; // node -> [node dependencies]
        unordered_map<int, vector<int>> adjList;
        for (vector<int>& pair : prerequisites) {
            indegrees[pair[0]]++;
            adjList[pair[1]].push_back(pair[0]);
        }

        queue<int> queue;
        for (int i = 0; i < numCourses; i++) {
            if (!indegrees[i]) queue.push(i);
        }

        vector<int> order;
        while (!queue.empty()) {
            int front = queue.front();
            queue.pop();
            order.push_back(front);
            for (int& dep : adjList[front]) {
                indegrees[dep]--;
                if (indegrees[dep] == 0) queue.push(dep);
            }
        }

        if (order.size() != numCourses) {
            return {};
        }

        return order;
    }
};
