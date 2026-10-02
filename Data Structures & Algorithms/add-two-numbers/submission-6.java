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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int first = l1 != null ? l1.val : 0;
            int second = l2 != null ? l2.val : 0;
            int sum = first + second + carry;
            if (sum >= 10) {
                current.next = new ListNode(sum % 10);
                carry = 1;
            } else {
                current.next = new ListNode(sum);
                carry = 0;
            }
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            current = current.next;
        }
        if (carry != 0) current.next = new ListNode(1);
        return dummy.next;
    }
}
