/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        
        ListNode[] nodes = half(head);

        ListNode first = nodes[0];
        ListNode start = first.next;
        first.next = null;

        ListNode reversed = reverse(start);
        debug(head);
        debug(reversed);

        interleave(head, reversed);
    }

    public void interleave(ListNode first, ListNode second) {
        while (second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;
            first.next = second;
            first.next.next = temp1;
            first = temp1;
            second = temp2;
        }
    }

    public void debug(ListNode head) {
        for (ListNode node = head; node != null; node = node.next) {
            System.out.print(node.val);
            System.out.print(" ");
        }
        System.out.println();
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }


    public ListNode[] half(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return new ListNode[] {slow, fast};
    }
}
