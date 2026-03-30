class Solution {
public:
    double myPow(double x, int n) {
        if (n < 0) {
            return 1/helper(x, -n);
        }
        return helper(x,n);
    }

    double helper(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n % 2 == 1) return myPow(x, n - 1) * x;
        double pow = myPow(x, n / 2);
        return pow * pow;
    }
};
