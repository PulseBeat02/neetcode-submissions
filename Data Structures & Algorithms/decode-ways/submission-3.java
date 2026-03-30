class Solution {

    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return decode(s, dp, 0);
    }

    public int decode(String s, int[] dp, int index) {

        if (index == s.length()) return 1;
        if (dp[index] != -1) return dp[index];

        char c = s.charAt(index);
        int firstDigit = c - '0';
        if (firstDigit == 0) return 0;

        boolean tryDecodeTwo = false;
        if (index + 1 < s.length()) {
            int secondDigit = s.charAt(index + 1) - '0';
            int sum = firstDigit * 10 + secondDigit;
            if (sum > 26) {
                tryDecodeTwo = false;
            } else {
                tryDecodeTwo = true;
            }
        }

        dp[index] = decode(s, dp, index + 1) + (tryDecodeTwo ? decode(s, dp, index + 2) : 0);
        return dp[index];
    }
}
