class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        int current = n;
        while (current != 1) {
            if (seen.contains(current)) return false;
            seen.add(current);
            int count = 0;
            while (current != 0) {
                count += (current % 10) * (current % 10);
                current /= 10;
            }
            current = count;
        }
        return true;
    }
}
