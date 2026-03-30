class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> queue = new PriorityQueue<>((first, second) -> {
            int dist0 = first[0] * first[0] + first[1] * first[1];
            int dist1 = second[0] * second[0] + second[1] * second[1];
            return dist0 - dist1;
        });
        for (int[] point : points) queue.add(point);
        int[][] arr = new int[k][2];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = queue.poll();
        }
        return arr;
    }
}
