class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            int[] last = res.get(res.size() - 1);
            if (last[1] >= start) {
                last[1] = Math.max(last[1], end);
            } else {
                res.add(interval);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

}
