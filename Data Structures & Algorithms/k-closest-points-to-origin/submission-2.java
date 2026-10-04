class Solution {

    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> {
            return (a[0] * a[0] + a[1] * a[1]) - 
                (b[0] * b[0] + b[1] * b[1]);
        });      
        for (int[] point : points) queue.add(point);
        int[][] arr = new int[k][2];
        for (int i = 0; i < k; i++) {
            arr[i] = queue.poll();
        }
        return arr;
    }
}
