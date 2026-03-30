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
    public Node copyRandomList(Node head) {

        Map<Node, Node> origToCopy = new HashMap<>();

        Node temp = head;
        Node back = null;
        Node first = null;
        while (temp != null) {
            Node copy = new Node(temp.val);
            origToCopy.put(temp, copy);
            if (back == null) {
                back = copy;
                first = back;
            } else {
                back.next = copy;
                back = back.next;
            }
            temp = temp.next;
        }

        Node origHead = head;
        Node copyHead = first;
        Node tempHead = copyHead;
        while (origHead != null && copyHead != null) {
            copyHead.random = origToCopy.get(origHead.random);
            origHead = origHead.next;
            copyHead = copyHead.next;
        }

        return tempHead;



    }
}
