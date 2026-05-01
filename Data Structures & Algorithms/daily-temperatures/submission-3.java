class Solution {

    // [30,38,30,36,35,40,28]
    //                   
    // 28 40


    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<int[]> stack = new Stack<>();
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int temp = temperatures[i];
            int[] arr = new int[] {temp, i};
            while (!stack.isEmpty() && temp >= stack.peek()[0]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                ans[i] = stack.peek()[1] - i;
            } else {
                ans[i] = 0;
            }

            stack.push(arr);
        }
        return ans;
    }
}
