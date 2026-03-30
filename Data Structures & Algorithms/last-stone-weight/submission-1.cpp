class Solution {
public:
    int lastStoneWeight(vector<int>& stones) {

        priority_queue<int, vector<int>> queue;
        for (int stone : stones) queue.push(stone);

        while (queue.size() > 1) {
            int biggest = queue.top();
            queue.pop();
            int secondBiggest = queue.top();
            queue.pop();
            if (secondBiggest < biggest) {
                queue.push(biggest - secondBiggest);
            }
        }

        return queue.empty() ? 0 : queue.top();
    }
};
