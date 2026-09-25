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
        ListNode[] halves = getHalves(head);
        ListNode first = halves[0];
        ListNode second = halves[1];
        second = reverse(second);
        head = interleave(first, second);
    }

    public ListNode interleave(ListNode first, ListNode second) {
        ListNode current = first;
        ListNode dummy = current;
        while (first != null && second != null) {
            ListNode temp = current.next;
            ListNode temp2 = second.next;
            current.next = second;
            second.next = (temp != null) ? temp : temp2;
            current = temp;
            second = temp2;
        }
        return dummy;
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

    // 2 4 6 8
    //     S   F
    public ListNode[] getHalves(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode firstHalf = head;
        ListNode secondHalf = slow.next;
        slow.next = null;
        return new ListNode[] {firstHalf, secondHalf};
    }
}
