class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> matches = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            List<List<Integer>> sols = getTriplets(nums, i);
            for (List<Integer> list : sols) {
                matches.add(list);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (List<Integer> list : matches) {
            ans.add(list);
        }

        return ans;
    }

    public List<List<Integer>> getTriplets(int[] nums, int excludeIndex) {
        int target = -nums[excludeIndex];
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        List<List<Integer>> ans = new ArrayList<>();
        while (left < right) {
            if (left == excludeIndex) {
                left++;
                continue;
            }
            if (right == excludeIndex) {
                right--;
                continue;
            }
            int sum = nums[left] + nums[right];
            if (sum == target) {
                List<Integer> list = Arrays.asList(nums[left], nums[right], nums[excludeIndex]);
                Collections.sort(list);
                ans.add(list);
                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}
