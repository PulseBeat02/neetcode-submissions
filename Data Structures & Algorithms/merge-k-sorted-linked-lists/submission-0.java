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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        for (int i = 1; i < lists.length; i++) {
            lists[i] = mergeTwoLists(lists[i], lists[i - 1]);
        }

        return lists[lists.length - 1];
    }

    public ListNode mergeTwoLists(ListNode first, ListNode second) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        while (first != null && second != null) {
            if (first.val < second.val) {
                current.next = new ListNode(first.val);
                first = first.next;
            } else {
                current.next = new ListNode(second.val);
                second = second.next;
            }
            current = current.next;
        }
        if (first != null) {
            current.next = first;
        } else if (second != null) {
            current.next = second;
        }
        return dummy.next;
    }
}
