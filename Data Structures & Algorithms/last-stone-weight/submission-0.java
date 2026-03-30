class Solution {
    public int lastStoneWeight(int[] stones) {

        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones) queue.add(stone);

        while (queue.size() > 1) {
            int heaviest = queue.poll();
            int secondHeaviest = queue.poll();
            if (heaviest == secondHeaviest) {
                // both destroyed
            } else if (secondHeaviest < heaviest) {
                queue.offer(heaviest - secondHeaviest);
            }
        }

        return queue.isEmpty() ? 0 : queue.poll();
    }
}
