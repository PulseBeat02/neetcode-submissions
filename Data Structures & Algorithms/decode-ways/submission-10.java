class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return decode(dp, s, 0);
    }

    public int decode(int[] dp, String s, int current) {

        int n = s.length();
        if (current >= n) return 1;
        if (dp[current] != -1) return dp[current];

        char[] chars = s.toCharArray();
        if (chars[current] == '0') return 0;

        int count = 0;
        if (current + 1 < n) {
            if (Integer.parseInt(chars[current] + "" + chars[current + 1]) <= 26) {
                count += decode(dp, s, current + 2);
            } 
        }

        count += decode(dp, s, current + 1);
        
        return dp[current] = count;
    }
}
