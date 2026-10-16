class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> list = new ArrayList<>();
        int[] current = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];
            if (next[0] <= current[1]) {
                current[1] = Math.max(current[1], next[1]);
            } else {
                list.add(current);
                current = next;
            }
        }
        list.add(current);

        int[][] arr = new int[list.size()][2];
        for (int i = 0; i < arr.length; i++) arr[i] = list.get(i);

        return arr;
    }
}
