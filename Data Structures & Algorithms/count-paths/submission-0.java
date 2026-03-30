class Solution {
    public int uniquePaths(int m, int n) {
        int top = m + n - 2;
        int bot = m - 1;
        return (int) nCr(top, bot);
    }

    public long nCr(int n, int r) {
        if (r < 0 || r > n) return 0;
        if (r > n - r) r = n - r;
        long result = 1;
        for (int i = 1; i <= r; i++) {
            result = result * (n - r + i) / i;
        }
        return result;
    }

}
