class Solution {

    public record Pair(int num, int index) {}

    public int[] maxSlidingWindow(int[] nums, int k) {
        Queue<Pair> queue = new PriorityQueue<>((a, b) -> Integer.compare(b.num, a.num));
        for (int i = 0; i < k; i++) {
            queue.add(new Pair(nums[i], i));
        }

        int n = nums.length;
        int[] ans = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            int start = i;
            int end = i + k - 1;
            while (queue.peek().index() < start) {
                queue.poll();
            }
            ans[i] = queue.peek().num();
            if (i + k < n) queue.add(new Pair(nums[i + k], i + k));
        }

        return ans;
    }
}
