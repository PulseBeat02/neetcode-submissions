class Solution {

    public record Pair(String symbol, int value) {}

    public String intToRoman(int num) {
    Pair[] pairs = {
        new Pair("I", 1),
        new Pair("IV", 4),
        new Pair("V", 5),
        new Pair("IX", 9),
        new Pair("X", 10),
        new Pair("XL", 40),
        new Pair("L", 50),
        new Pair("XC", 90),
        new Pair("C", 100),
        new Pair("CD", 400),
        new Pair("D", 500),
        new Pair("CM", 900),
        new Pair("M", 1000)
    };
        StringBuilder sb = new StringBuilder("");
        for (int i = pairs.length - 1; i >= 0; i--) {
            Pair pair = pairs[i];
            if (num < pair.value) continue;
            int copies = num / pair.value();
            sb.append(pair.symbol().repeat(copies));
            num %= pair.value();
        }
        return sb.toString();
    }
}