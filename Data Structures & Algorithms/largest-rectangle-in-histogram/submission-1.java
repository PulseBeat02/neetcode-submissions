class Solution {

    public record Pair(int start, int height) {}

    public int largestRectangleArea(int[] heights) {

        int n = heights.length;
        List<Integer> list = new ArrayList<>();
        for (int height : heights) list.add(height);
        list.add(0); // calculate last heights

        Stack<Pair> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i < list.size(); i++) {
            int height = list.get(i);
            int start = i;
            while (!stack.isEmpty() && height < stack.peek().height) {
                Pair pair = stack.pop();
                maxArea = Math.max(maxArea, (i - pair.start) * pair.height);
                start = pair.start;
            }
            stack.push(new Pair(start, height));
        }
        
        return maxArea;
    }
}
