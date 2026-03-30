class MinStack {
public:

    stack<int> main;
    stack<int> min;

    MinStack() {
        
    }
    
    void push(int val) {
        main.push(val);
        if (min.empty()) {
            min.push(val);
        } else if (val < min.top()) {
            min.push(val);
        } else {
            min.push(min.top());
        }
    }
    
    void pop() {
        main.pop();
        min.pop();
    }
    
    int top() {
        return main.top();
    }
    
    int getMin() {
        return min.top();
    }
};
