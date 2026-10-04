class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones) queue.add(stone);
        while (queue.size() > 1) {
            int x = queue.poll();
            int y = queue.poll();
            if (x == y) continue;
            else {
                queue.add(x - y);
            }
        }
        return queue.isEmpty() ? 0 : queue.poll();
    }
}
