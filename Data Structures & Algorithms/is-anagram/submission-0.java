class Solution {
    public boolean isAnagram(String s, String t) {
        int[] counts = new int[26];
        for (char c : s.toCharArray()) counts[c - 'a']++;
        int[] newCounts = new int[26];
        for (char c : t.toCharArray()) newCounts[c - 'a']++;
        return Arrays.equals(counts, newCounts);
    }
}
