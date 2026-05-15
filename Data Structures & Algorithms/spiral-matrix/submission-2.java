class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        int dir = 0;
        int[][] steps = new int[][] {
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}
        };

        int[] lengths = new int[] {
            matrix[0].length,
            matrix.length - 1,
            matrix[0].length - 1,
            matrix.length - 2
        };

        boolean[] visited = new boolean[4];

        int r = 0;
        int c = 0;

        int traversed = 0;
        int max = matrix.length * matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        int current = 0;
        while (true) {
            ans.add(matrix[r][c]);
            traversed++;
            current++;

            if (traversed == max) break;

            if (current == lengths[dir]) {
                visited[dir] = true;
                dir = (dir + 1) % 4;
                if (visited[dir]) lengths[dir] -= 2;
                current = 0;
            }

            r += steps[dir][0];
            c += steps[dir][1];
        }

        return ans;
    }
}