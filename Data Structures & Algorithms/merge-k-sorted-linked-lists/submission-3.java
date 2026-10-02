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
        if (lists.length == 0) return null;
        Queue<ListNode> queue = new LinkedList<>();
        for (ListNode list : lists) queue.add(list);
        while (queue.size() != 1) {
            ListNode first = queue.poll();
            ListNode second = queue.poll();
            queue.add(merge(first, second));
        }
        return queue.poll();
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        while (l1 != null || l2 != null) {
            int first = l1 != null ? l1.val : Integer.MAX_VALUE;
            int second = l2 != null ? l2.val : Integer.MAX_VALUE;
            if (first < second) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        return dummy.next;
    }
}










