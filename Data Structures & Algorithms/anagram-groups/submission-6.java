class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> groups = new HashMap<>();
        for (String str : strs) {
            int[] freqs = getCharacterFrequencies(str);
            int hash = Arrays.hashCode(freqs);
            if (!groups.containsKey(hash)) {
                List<String> list = new ArrayList<>();
                list.add(str);
                groups.put(hash, list);
            } else {
                groups.get(hash).add(str);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry : groups.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }

    public int[] getCharacterFrequencies(String str) {
        int[] freqs = new int[26];
        char[] chars = str.toCharArray();
        for (char c : chars) freqs[c - 'a']++;
        return freqs;
    }
}
