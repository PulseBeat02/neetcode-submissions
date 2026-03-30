class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        return recurse(s, dp, wordDict, 0);
    }

    public boolean recurse(String s, int[] dp, List<String> wordDict, int index) {
        if (index == s.length()) return true;
        if (dp[index] != -1) return dp[index] == 1;
        for (String word : wordDict) {
            int len = word.length();
            if (index + len <= s.length() && s.startsWith(word, index)) {
                if (recurse(s, dp, wordDict, index + len)) {
                    dp[index] = 1;
                    return true;
                }
            }
        }
        dp[index] = 0;
        return false;
    }
}
