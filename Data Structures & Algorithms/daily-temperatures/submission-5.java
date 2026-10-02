class Solution {
    public record Pair(int temp, int index) {}
    public int[] dailyTemperatures(int[] temperatures) {
        //
        //
        //
        // (38, 1)
        // (30, 0)
        int n = temperatures.length;
        Stack<Pair> stack = new Stack<>();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && stack.peek().temp < temperature) {
                Pair popped = stack.pop();
                ans[popped.index] = i - popped.index;
            }
            stack.push(new Pair(temperature, i));
        }
        return ans;
    }
}
