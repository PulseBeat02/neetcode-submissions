class MinStack {

    Stack<Integer> main = new Stack<>();
    Stack<Integer> prefix = new Stack<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        main.push(val);
        if (prefix.isEmpty()) {
            prefix.push(val);
        } else {
            if (val <= prefix.peek()) {
                prefix.push(val);
            } else {
                prefix.push(prefix.peek());
            }
        }
    }
    
    public void pop() {
        main.pop();
        prefix.pop();
    }
    
    public int top() {
        return main.peek();
    }
    
    public int getMin() {
        return prefix.peek();
    }
}
