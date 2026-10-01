class Solution {
    public boolean isAnagram(String s, String t) {
        int[] first = getFreqs(s);
        int[] second = getFreqs(t);
        return Arrays.equals(first, second);
    }

    public int[] getFreqs(String s) {
        int[] freqs = new int[26];
        char[] arr = s.toCharArray();
        for (char c : arr) freqs[c - 'a']++;
        return freqs;
    }
}
