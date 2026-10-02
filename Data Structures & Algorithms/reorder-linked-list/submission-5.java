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
        ListNode[] split = split(head);
        head = interleave(split[0], reverse(split[1]));
    }

    public ListNode interleave(ListNode first, ListNode second) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        while (first != null && second != null) {
            current.next = first;
            current = current.next;
            first = first.next;
            
            current.next = second;
            current = current.next;
            second = second.next;
        }
        if (first != null) current.next = first;
        else if (second != null) current.next = second;
        return dummy;
    }

    public ListNode[] split(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 2 4 6| 8 10
        ListNode first = head;
        ListNode second = slow.next;
        slow.next = null;
        return new ListNode[] {first, second};
    }

    public ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }
}
