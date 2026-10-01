class Solution {

    public String encode(List<String> strs) {
        // [length] + # + [str]
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length());
            sb.append('#');
            sb.append(str);
        }
        return sb.toString();
    }

    // 2#de 5
    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        char[] chars = str.toCharArray();
        int start = 0;
        for (int end = 0; end < chars.length; end++) {
            char c = chars[end];
            if (c == '#') {
                int size = Integer.parseInt(str.substring(start, end));
                String tmp = str.substring(end + 1, end + size + 1);
                ans.add(tmp);
                start = end + size + 1;
                end = end + size + 1;
            }
        }
        return ans;
    }
}
