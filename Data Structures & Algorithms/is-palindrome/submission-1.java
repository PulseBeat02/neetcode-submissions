class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int left = 0;
        int right = n - 1;
        String lower = s.toLowerCase();
        while (left < right) {
            if (!Character.isLetterOrDigit(lower.charAt(left))) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(lower.charAt(right))) {
                right--;
                continue;
            }
            if (lower.charAt(left) != lower.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
