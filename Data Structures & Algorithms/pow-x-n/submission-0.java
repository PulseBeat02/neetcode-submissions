class Solution {
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1;
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        double pow = myPow(x, n / 2);
        if (n % 2 == 1) return pow * pow * x;
        else return pow * pow;
    }
}
