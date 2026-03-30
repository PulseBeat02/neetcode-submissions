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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode node = new ListNode();
        ListNode head = node;
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                node.next = list2;
                break;
            } else if (list2 == null) {
                node.next = list1;
                break;
            }
            int val1 = list1.val;
            int val2 = list2.val;
            if (val1 < val2) {
                node.next = new ListNode(val1);
                node = node.next;
                list1 = list1.next;
            } else {
                node.next = new ListNode(val2);
                node = node.next;
                list2 = list2.next;
            }
        }
        return head.next;
    }
}