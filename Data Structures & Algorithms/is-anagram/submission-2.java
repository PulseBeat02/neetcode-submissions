class Solution {
    public boolean isAnagram(String s, String t) {
        char[] first = s.toCharArray();
        char[] second = t.toCharArray();
        int[] firstFreqs = new int[26];
        int[] secondFreqs = new int[26];
        for (char c : first) firstFreqs[c - 'a']++;
        for (char c : second) secondFreqs[c - 'a']++;
        return Arrays.equals(firstFreqs, secondFreqs);
    }
}
