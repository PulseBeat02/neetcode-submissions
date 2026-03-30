class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            Set<Character> search = new HashSet<>();
            int count = 0;
            while ((i + count < n) && !search.contains(arr[i + count])) {
                search.add(arr[i + count]);
                count++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
