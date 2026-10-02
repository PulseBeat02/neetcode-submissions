class MinStack {

    Stack<Integer> stack;
    Stack<Integer> mins;

    public MinStack() {
        this.stack = new Stack<>();
        this.mins = new Stack<>();
    }
    
    public void push(int val) {
        this.stack.push(val);
        if (!mins.empty()) {
            int peek = mins.peek();
            if (peek < val) {
                mins.push(peek);
            } else {
                mins.push(val);
            }
        } else {
            mins.push(val);
        }
    }

    // norm min
    //  0    0
    //  2    1
    //  1    1
    
    public void pop() {
        stack.pop();
        mins.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return mins.peek();
    }
}
