#define ll long long

class Solution {
public:

    // (m + n - 2) choose (m - 1)
    // (m + n - 2) - (m - 1) = m + n - 2 - m + 1 = n - 1

    int uniquePaths(int m, int n) {
        return (factorial(m + n - 2) / (factorial(m - 1) * factorial(n - 1)));
    }

    ll factorial(int num) {
        if (num == 0) return 1;
        ll prod = 1;
        for (int i = 1; i <= num; i++) {
            prod *= i;
        }
        return prod;
    }
};
