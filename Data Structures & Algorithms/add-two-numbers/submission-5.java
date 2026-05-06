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
        ListNode head = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int first = l1 != null ? l1.val : 0;
            int second = l2 != null ? l2.val : 0;
            int sum = first + second + carry;
            int value;
            if (sum >= 10) {
                carry = 1;
                value = sum - 10;
            } else {
                carry = 0;
                value = sum;
            }
            ListNode node = new ListNode(value);
            head.next = node;
            head = head.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry != 0) {
            ListNode carryNode = new ListNode(carry);
            head.next = carryNode;
        }
        return dummy.next;
    }
}
