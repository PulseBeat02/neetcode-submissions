class Solution {
public:
    bool isPalindrome(string s) {
        int n = s.length();
        int left = 0;
        int right = n - 1;
        while (left < right) {
            if (!isalnum(s[left])) {
                left++;
                continue;
            }
            if (!isalnum(s[right])) {
                right--;
                continue;
            }
            char leftChar = tolower(s[left]);
            char rightChar = tolower(s[right]);
            if (leftChar != rightChar) return false;
            left++;
            right--;
        }
        return true;
    }
};
