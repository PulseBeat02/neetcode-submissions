class KthLargest {
public:

    priority_queue<int, vector<int>, greater<int>> queue;
    int k;

    KthLargest(int k, vector<int>& nums) {
        this->k = k;
        for (int num : nums) {
            queue.push(num);
            if (queue.size() > k) {
                queue.pop();
            }
        }        
    }
    
    int add(int val) {
        queue.push(val);
        if (queue.size() > k) {
            queue.pop();
        }
        return queue.top();
    }
};
