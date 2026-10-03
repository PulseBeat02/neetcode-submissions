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
    public ListNode reverseKGroup(ListNode head, int k) {

        List<ListNode> groups = new ArrayList<>();
        int count = 0;
        ListNode left = head;
        ListNode right = head;
        while (right != null) {
            count++;
            if (count % k == 0) {
                ListNode temp = right.next;
                right.next = null;
                groups.add(left);
                right = temp;
                left = right;
            } else {
                right = right.next;
            }
        }
        if (left != right) groups.add(left);

        List<ListNode> reversedGroups = new ArrayList<>();
        for (int i = 0; i < groups.size(); i++) {
            if (i == groups.size() - 1 && count % k != 0) {
                reversedGroups.add(groups.get(i));
            } else {
                reversedGroups.add(reverse(groups.get(i)));
            }
        }

        ListNode dummy = new ListNode();
        ListNode current = dummy;
        for (ListNode group : reversedGroups) {
            ListNode innerCurrent = group;
            while (innerCurrent != null) {
                current.next = innerCurrent;
                current = current.next;
                innerCurrent = innerCurrent.next;
            }
        }

        return dummy.next;        
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
