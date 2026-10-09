class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        /*
        Hierholzer’s Algorithm (build Eulerian path with edges)
Pick a starting node and push it onto a stack
While the stack is not empty:
  Let curr = top of the stack
  If curr has any unused outgoing edges:
Pick one unused edge (curr → next)
Remove that edge from the graph (mark it used)
Push next onto the stack
  Else:
Pop curr from the stack and append it to the path
Reverse the path to get the final Eulerian path or circuit
        */
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
