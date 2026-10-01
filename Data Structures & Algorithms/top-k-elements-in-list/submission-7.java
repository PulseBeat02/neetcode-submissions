class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        int n = nums.length;

        // num -> frequency
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int num : nums) {
            frequencies.put(num, frequencies.getOrDefault(num, 0) + 1);
        }

        List<List<Integer>> frequencyOfFrequencies = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            frequencyOfFrequencies.add(new ArrayList<>());
        }

        for (Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {
            frequencyOfFrequencies.get(entry.getValue()).add(entry.getKey());
        }

        int[] ans = new int[k];
        int curr = 0;
        for (int i = n; i >= 0; i--) {
            List<Integer> list = frequencyOfFrequencies.get(i);
            if (list.isEmpty()) continue;
            for (int j = 0; j < list.size(); j++) {
                ans[curr] = list.get(j);
                curr++;
                if (curr == k) return ans;
            }
        }

        return new int[] {};
        
    }
}
