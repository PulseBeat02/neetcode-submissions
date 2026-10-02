class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;
        int n = r * c;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            int nR = mid / c;
            int nC = mid % c;
            int current = matrix[nR][nC];
            if (current == target) {
                return true;
            } else if (current < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
