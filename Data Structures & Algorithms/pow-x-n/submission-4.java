class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n < 0) {
            double half = myPow(x, -(n / 2));
            double full = half * half;
            if (-n % 2 == 1) {
                return 1 / (full * x);
            } else {
                return 1 / full;
            }
        } else {
            double half = myPow(x, n / 2);
            double full = half * half;
            if (n % 2 == 1) {
                return full * x;
            } else {
                return full;
            }
        }
    }
}
