class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int[] ans = new int[n - k + 1];

        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            queue.offer(nums[i]);
        }
        ans[0] = queue.peek();

        // 7 - 3
        // 4
        for (int i = 1; i <= n - k; i++) {
            queue.remove(nums[i - 1]);
            queue.offer(nums[i + k - 1]);
            ans[i] = queue.peek();
        }

        return ans;
    }
}
