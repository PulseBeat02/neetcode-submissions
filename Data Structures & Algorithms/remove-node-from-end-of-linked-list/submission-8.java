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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        int size = 0;
        for (ListNode current = head; current != null; current = current.next) size++;

        int index = size - n;
        if (index == 0) return head.next;

        ListNode target = head;
        for (int i = 0; i < index - 1; i++) target = target.next;

        target.next = target.next.next;
        
        return head;
        
    }
}
