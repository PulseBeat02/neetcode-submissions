class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) counts.put(num, counts.getOrDefault(num, 0) + 1);

        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < nums.length + 1; i++) {
            buckets.add(new ArrayList<>());
        }

        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            int number = entry.getKey();
            int frequency = entry.getValue();
            buckets.get(frequency).add(number);
        }

        int[] res = new int[k];
        int ansIndex = 0;
        for (int i = buckets.size() - 1; i >= 0; i--) {
            List<Integer> list = buckets.get(i);
            for (int j = 0; j < list.size(); j++) {
                if (ansIndex == k) return res;
                res[ansIndex] = list.get(j);
                ansIndex++;
            }
        }

        return res;
    }
}
