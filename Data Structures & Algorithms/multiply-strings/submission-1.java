class Solution {
    public String multiply(String num1, String num2) {
        return String.valueOf(convert(num1) * convert(num2));
    }

    public long convert(String num) {
        long sum = 0;
        int base = 1;
        for (int i = num.length() - 1; i >= 0; i--) {
            sum += ((num.charAt(i) - '0') * base);
            base *= 10;
        }
        return sum;
    }
}
