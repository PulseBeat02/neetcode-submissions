class MedianFinder {

    Queue<Integer> lower = new PriorityQueue<>(Comparator.reverseOrder());
    Queue<Integer> higher = new PriorityQueue<>();

    // [1,2,3]

    // [1] []


    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        
        if (lower.isEmpty() || num <= lower.peek()) {
            lower.offer(num);
        } else {
            higher.offer(num);
        }

        if (lower.size() > higher.size() + 1) {
            higher.offer(lower.poll());
        } else if (higher.size() > lower.size() + 1) {
            lower.offer(higher.poll());
        }
    }
    
    public double findMedian() {
        if (lower.size() == higher.size()) {
            return (lower.peek() + higher.peek()) / 2.0;
        } else if (lower.size() < higher.size()) {
            return higher.peek();
        } else {
            return lower.peek();
        }
    }
}
