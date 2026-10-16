
class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[] ans = new int[queries.length];
        Arrays.fill(ans, -1);

        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            int idx = binarySearch(intervals, query);

            for (int j = idx; j >= 0; j--) {
                if (intervals[j][1] >= query) {
                    int length = intervals[j][1] - intervals[j][0] + 1;

                    if (ans[i] == -1 || length < ans[i]) {
                        ans[i] = length;
                    }
                }
            }
        }

        return ans;
    }

    private int binarySearch(int[][] intervals, int query) {
        int left = 0;
        int right = intervals.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (intervals[mid][0] <= query) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}
