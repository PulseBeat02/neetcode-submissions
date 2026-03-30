class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int left = 0;
        int right = n - 1;
        int max = -1;
        while (left < right) {
            int area = calculateArea(left, right, heights[left], heights[right]);
            max = Math.max(area, max);
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    public int calculateArea(int i, int j, int first, int second) {
        return (j - i) * Math.min(first, second);
    }
}
