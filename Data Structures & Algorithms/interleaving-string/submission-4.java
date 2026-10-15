class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        int[][] dp = new int[s3.length() + 1][s3.length() + 1];
        for (int[] arr : dp) Arrays.fill(arr, -1);
        return interleave(dp, s1, 0, s2, 0, 0, s3);
    }

    public boolean interleave(int[][] dp, String first, int firstIndex, String second, int secondIndex, int current, String target) {
        if (current == target.length()) return true;
        if (dp[firstIndex][secondIndex] != -1) return dp[firstIndex][secondIndex] == 1;
        boolean res = false;
        if (firstIndex < first.length() && first.charAt(firstIndex) == target.charAt(current)) {
            res = interleave(dp, first, firstIndex + 1, second, secondIndex, current + 1, target);
        }
        if (secondIndex < second.length() && second.charAt(secondIndex) == target.charAt(current)) {
            res = res || interleave(dp, first, firstIndex, second, secondIndex + 1, current + 1, target);
        }
        dp[firstIndex][secondIndex] = res ? 1 : 0;
        return res;
    }
}
