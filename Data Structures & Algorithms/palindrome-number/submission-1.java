class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int copy = x;
        int sum = 0;
        while (copy != 0) {
            int digit = copy % 10;
            sum = sum * 10 + digit;
            copy /= 10;
        }
        return sum == x;
    }
}