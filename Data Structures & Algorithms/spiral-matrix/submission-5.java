
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int target = rows * cols;
        int count = 1;

        List<Integer> list = new ArrayList<>();
        int direction = 0;
        // 0 right
        // 1 down
        // 2 left
        // 3 up

        int r = 0;
        int c = 0;
        int horizontal = cols;
        int vertical = rows - 1;
        int move = horizontal - 1;

        list.add(matrix[0][0]);

        while (count < target) {
            if (direction == 0) {
                for (int i = 0; i < move && count < target; i++) {
                    c++;
                    list.add(matrix[r][c]);
                    count++;
                }
                direction = 1;
                horizontal--;
                move = vertical;
            } else if (direction == 1) {
                for (int i = 0; i < move && count < target; i++) {
                    r++;
                    list.add(matrix[r][c]);
                    count++;
                }
                direction = 2;
                vertical--;
                move = horizontal;
            } else if (direction == 2) {
                for (int i = 0; i < move && count < target; i++) {
                    c--;
                    list.add(matrix[r][c]);
                    count++;
                }
                direction = 3;
                horizontal--;
                move = vertical;
            } else if (direction == 3) {
                for (int i = 0; i < move && count < target; i++) {
                    r--;
                    list.add(matrix[r][c]);
                    count++;
                }
                direction = 0;
                vertical--;
                move = horizontal;
            }
        }

        return list;
    }
}
