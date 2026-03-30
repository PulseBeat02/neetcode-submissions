class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s2.length() < s1.length()) return false;

        int[] target = new int[26];
        for (char c : s1.toCharArray()) target[c - 'a']++;

        int[] test = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            test[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(target, test)) return true;

        for (int i = 1; i <= s2.length() - s1.length(); i++) {
            test[s2.charAt(i - 1) - 'a']--;
            test[s2.charAt(i + s1.length() - 1) - 'a']++;
            System.out.println(Arrays.toString(test));
            if (Arrays.equals(target, test)) return true;
        }

        return false;
    }
}
