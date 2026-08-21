class MinStack {
public:

    stack<int> original;
    stack<int> mins;

    MinStack() {
        
    }
    
    void push(int val) {
        original.push(val);
        if (mins.empty() || val <= mins.top()) {
            mins.push(val);
        }
    }
    
    void pop() {
        int top = original.top();
        original.pop();
        int min = mins.top();
        if (top == min) mins.pop();
    }
    
    int top() {
        return original.top();
    }
    
    int getMin() {
        return mins.top();
    }
};
