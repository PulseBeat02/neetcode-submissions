/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {

    Map<Node, Node> copy = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        if (copy.containsKey(head)) return copy.get(head);
        Node temp = new Node(head.val);
        copy.put(head, temp);
        temp.next = copyRandomList(head.next);
        temp.random = copyRandomList(head.random);
        return temp;
    }
}








