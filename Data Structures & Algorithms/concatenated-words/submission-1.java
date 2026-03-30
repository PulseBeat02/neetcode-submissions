class Solution {

    Map<String, Boolean> map = new HashMap<>();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> list = new ArrayList<>();
        for (String word : words) {
            if (concatenated(words, "", word)) list.add(word);
        }
        return list;
    }

    public boolean concatenated(String[] words, String current, String target) {
        if (current.equals(target)) return true;
        if (map.containsKey(current + "|" + target)) return map.get(current + "|" + target);
        for (String word : words) {
            if (!target.startsWith(current + word)) continue;
            if (word.equals(target)) continue;
            if (concatenated(words, current + word, target)) {
                map.put(current + "|" + target, true);
                return true;
            }
        }
        map.put(current + "|" + target, false);
        return false;
    }
}