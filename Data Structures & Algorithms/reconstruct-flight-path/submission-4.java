class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            map.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>())
                .add(ticket.get(1));
        }

        List<String> res = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        stack.add("JFK");

        while (!stack.isEmpty()) {
            String current = stack.peek();
            Queue<String> neighbors = map.getOrDefault(current, new PriorityQueue<>());
            if (neighbors.isEmpty()) {
                res.add(stack.pop());
            } else {
                stack.push(neighbors.poll());
            }
        }

        Collections.reverse(res);

        return res;
    }
}
