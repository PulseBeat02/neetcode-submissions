class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) {
            if (interval[1] < newInterval[0]) {
                res.add(interval);
            } else if (interval[0] > newInterval[1]) {
                res.add(newInterval);
                newInterval = interval;
            } else {
                newInterval = new int[] {Math.min(newInterval[0], interval[0]), Math.max(newInterval[1], interval[1])};
            }
        }
        res.add(newInterval);
        return convert(res);
    }

    public int[][] convert(List<int[]> list) {
        int[][] arr = new int[list.size()][list.get(0).length];
        int index = 0;
        for (int[] sub : list) {
            arr[index] = sub;
            index++;
        }
        return arr;
    }
}
