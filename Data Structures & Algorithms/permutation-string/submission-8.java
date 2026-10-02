class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int n = s2.length();
        int[] base = getFrequencies(s1);
        int k = s1.length();

        int[] current = new int[26];
        for (int i = 0; i < k; i++) { // first window
            current[s2.charAt(i) - 'a']++;
        }
        if (isPermutation(base, current)) return true;

        for (int i = k; i < n; i++) {
            current[s2.charAt(i) - 'a']++;
            current[s2.charAt(i - k) - 'a']--;
            if (isPermutation(base, current)) return true;
        }
        return false;
    }

    public int[] getFrequencies(String s1) {
        int[] freqs = new int[26];
        int n = s1.length();
        for (int i = 0; i < n; i++) {
            freqs[s1.charAt(i) - 'a']++;
        }
        return freqs;
    }

    public boolean isPermutation(int[] base, int[] current) {
        int n = base.length;
        for (int i = 0; i < n; i++) {
            if (current[i] != base[i]) return false;
        }
        return true;
    }
}
