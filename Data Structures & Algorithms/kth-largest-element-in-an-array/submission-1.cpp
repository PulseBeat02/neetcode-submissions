class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int, vector<int>, greater<int>> queue; // min heap
        for (int num : nums) {
            if (queue.size() < k) {
                queue.push(num);
            } else if (num > queue.top()) {
                queue.pop();
                queue.push(num);
            }
        }
        return queue.top();
    }
};
