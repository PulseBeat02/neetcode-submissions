class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> groups = new HashMap<>();
        for (String str : strs) {
            int[] letters = new int[26];
            for (char c : str.toCharArray()) letters[c - 'a']++;
            int key = Arrays.hashCode(letters);
            if (groups.containsKey(key)) {
                groups.get(key).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                groups.put(key, list);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        Collection<List<String>> values = groups.values();
        for (List<String> value : values) {
            ans.add(value);
        }
        return ans;
    }
}
