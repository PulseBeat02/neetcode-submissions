class MedianFinder {

    Queue<Integer> maxHeap; // first
    Queue<Integer> minHeap; // second

    public MedianFinder() {
        this.maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        this.minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (minHeap.isEmpty()) { // both empty
            minHeap.add(num);
            return;
        }

        if (num >= minHeap.peek()) {
            minHeap.add(num);
        } else {
            maxHeap.add(num);
        }

        // guarantee that second half has median for odd elements
        if (maxHeap.size() > minHeap.size()) {
            minHeap.add(maxHeap.poll());
        } else if (minHeap.size() - 1 > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }

    }
    
    public double findMedian() {
        if ((minHeap.size() + maxHeap.size()) % 2 == 1) {
            return minHeap.peek();
        }
        return (minHeap.peek() + maxHeap.peek()) / 2.0d;
    }
}
