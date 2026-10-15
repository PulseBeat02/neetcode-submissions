class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for (int[] arr : dp) Arrays.fill(arr, -1);
        return operations(dp, word1, 0, word2, 0);
    }

    public int operations(int[][] dp, String original, int originalIndex, String target, int targetIndex) {
        if (targetIndex == target.length()) return original.length() - originalIndex;
        if (originalIndex == original.length()) return target.length() - targetIndex;
        if (dp[originalIndex][targetIndex] != -1) return dp[originalIndex][targetIndex];
        // skip if both characters equal
        int min = Integer.MAX_VALUE;
        if (original.charAt(originalIndex) == target.charAt(targetIndex)) {
            min = Math.min(min, operations(dp, original, originalIndex + 1, target, targetIndex + 1));
        } else {
            // 1) Insert
            min = Math.min(min, operations(dp, original, originalIndex, target, targetIndex + 1) + 1);
            // 2) Delete
            min = Math.min(min, operations(dp, original, originalIndex + 1, target, targetIndex) + 1);
            // 3) Replace
            min = Math.min(min, operations(dp, original, originalIndex + 1, target, targetIndex + 1) + 1);
        }
        return dp[originalIndex][targetIndex] = min;
    }
}
