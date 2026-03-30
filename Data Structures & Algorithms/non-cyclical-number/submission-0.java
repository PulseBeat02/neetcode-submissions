class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();
        while (n != 1) {
            if (visited.contains(n)) return false;
            visited.add(n);
            String str = String.valueOf(n);
            int sum = 0;
            for (char c : str.toCharArray()) {
                sum += (c - '0') * (c - '0');
            }
            n = sum;
        }
        return true;
    }
}
