class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int[] target = new int[26];
        for (char c : s1.toCharArray()) target[c - 'a']++;

        // 3 (total: 7)
        // 4
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            String str = s2.substring(i, i + s1.length());
            int[] test = new int[26];
            for (char c : str.toCharArray()) test[c - 'a']++;
            if (Arrays.equals(target, test)) return true;
        }

        return false;
    }
}
