class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        int n = nums.length;

        Map<Integer, Integer> freqs = new HashMap<>();
        for (int num : nums) {
            if (freqs.containsKey(num)) {
                freqs.put(num, freqs.get(num) + 1);
            } else {
                freqs.put(num, 1);
            }
        }

        List<List<Integer>> buckets = new ArrayList<>(n);
        for (int i = 0; i <= n; i++) {
            buckets.add(null);
        }

        for (Map.Entry<Integer, Integer> freq : freqs.entrySet()) {
            int number = freq.getValue();
            int value = freq.getKey();
            if (buckets.get(number) == null) {
                List<Integer> first = new ArrayList<>();
                first.add(value);
                buckets.set(number, first);
            } else {
                buckets.get(number).add(value);  
            }
        }

        int[] ans = new int[k];
        int j = 0;
        for (int i = n; i >= 0; i--) {
            List<Integer> list = buckets.get(i);
            if (list == null || list.isEmpty()) continue;
            for (int value : list) {
                ans[j] = value;
                j++;
                if (j == k) return ans;
            }
        }

        return new int[] {};

    }
}
