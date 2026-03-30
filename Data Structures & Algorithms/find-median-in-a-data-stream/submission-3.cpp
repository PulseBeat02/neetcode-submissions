class MedianFinder {
public:

    // balance heap

    priority_queue<int> max_heap;
    priority_queue<int, vector<int>, greater<int>> min_heap;

    MedianFinder() {
        
    }
    
    void addNum(int num) {
        if (max_heap.empty() && min_heap.empty()) {
            max_heap.push(num);
        } else {
            if (num <= max_heap.top()) {
                max_heap.push(num);
            } else {
                min_heap.push(num);
            }
        }

        if (!max_heap.empty() && !min_heap.empty() && max_heap.top() > min_heap.top()) {
            int a = max_heap.top(); max_heap.pop();
            int b = min_heap.top(); min_heap.pop();
            max_heap.push(b);
            min_heap.push(a);
        }

        // rebalance
        int minSize = min_heap.size();
        int maxSize = max_heap.size();
        if (abs(minSize - maxSize) > 1) {
            if (minSize > maxSize) {
                int top = min_heap.top();
                min_heap.pop();
                max_heap.push(top);
            } else {
                int top = max_heap.top();
                max_heap.pop();
                min_heap.push(top);
            }
        }
    }
    
    double findMedian() {
        int minSize = min_heap.size();
        int maxSize = max_heap.size();
        if (minSize == maxSize) {
            return static_cast<double>((min_heap.top() + max_heap.top()) / 2.0);
        } else if (minSize > maxSize) {
            return min_heap.top();
        } else {
            return max_heap.top();
        }
    }
};
