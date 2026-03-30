class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) counts.put(num, counts.getOrDefault(num, 0) + 1);

        Queue<int[]> queue = new PriorityQueue<>((first, second) -> second[1] - first[1]);

        for (int key : counts.keySet()) {
            queue.offer(new int[] {key, counts.get(key)});
        }

        int[] results = new int[k];
        for (int i = 0; i < k; i++) {
            results[i] = queue.poll()[0];
        }

        return results;
    }
}
