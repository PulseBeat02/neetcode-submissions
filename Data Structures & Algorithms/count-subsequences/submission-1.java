class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for (int[] arr : dp) Arrays.fill(arr, -1);
        return num(dp, s, 0, t, 0);
    }



    public int num(int[][] dp, String original, int originalIndex, String target, int targetIndex) {
        if (targetIndex == target.length()) return 1;
        if (originalIndex >= original.length()) return 0;
        if (dp[originalIndex][targetIndex] != -1) return dp[originalIndex][targetIndex];
        int count = 0;
        if (original.charAt(originalIndex) == target.charAt(targetIndex)) {
            // either continue now
            count += num(dp, original, originalIndex + 1, target, targetIndex + 1);
            // or later
            count += num(dp, original, originalIndex + 1, target, targetIndex);
        } else {
            // can only go later
            count = num(dp, original, originalIndex + 1, target, targetIndex);
        }
        return dp[originalIndex][targetIndex] = count;
    }
}
