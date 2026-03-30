class Solution {

    public String encode(List<String> strs) {
        StringBuffer sb = new StringBuffer();
        for (String word : strs) {
            sb.append(word.length());
            sb.append('#');
            sb.append(word);
        }
        return sb.toString();
    }

    // 2#ab

    public List<String> decode(String str) {
        int index = 0;
        List<String> list = new ArrayList<>();
        while (index < str.length()) {
            int j = index;
            while (str.charAt(j) != '#') j++;
            int length = Integer.parseInt(str.substring(index, j));
            j++;
        String word = str.substring(j, j + length);
        list.add(word);

        index = j + length;
        }
        return list;
    }
}
