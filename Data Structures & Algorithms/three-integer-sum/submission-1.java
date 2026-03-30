class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> sums = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int target = -nums[i];
            List<List<Integer>> detect = twoSum(nums, target, i);
            for (List<Integer> res : detect) {
                List<Integer> list = new ArrayList<>();
                list.add(res.get(0));
                list.add(res.get(1));
                list.add(nums[i]);
                Collections.sort(list);
                sums.add(list);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (List<Integer> list : sums) {
            res.add(list);
        }
        return res;
    }

    public List<List<Integer>> twoSum(int[] nums, int target, int blacklist) {
        Set<Integer> set = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i == blacklist) continue;
            if (set.contains(nums[i])) {
                res.add(List.of(nums[i], target - nums[i]));
            }
            set.add(target - nums[i]);
        }
        return res;
    }
}
