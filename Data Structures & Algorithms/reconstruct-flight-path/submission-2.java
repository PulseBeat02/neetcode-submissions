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
            if (!map.containsKey(current) || map.get(current).isEmpty()) {
                res.addFirst(stack.pop());
            } else {
                stack.push(map.get(current).poll());
            }
        }

        return res;
    }
}
