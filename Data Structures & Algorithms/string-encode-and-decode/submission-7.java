class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            int len = str.length();
            sb.append(len).append("#").append(str);
        }
        return sb.toString();
    }

    // ["Hello","World"]
    // Encode -> 5#Hello5#World
    //             2    7

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        char[] chars = str.toCharArray();
        String num = "";
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c != '#') {
                num += c;
                continue;
            }
            int len = Integer.parseInt(num);
            num = "";
            i++;
            int max = i + len;
            String res = str.substring(i, max);
            ans.add(res);
            i = max - 1;
        }
        return ans;
    }
}
