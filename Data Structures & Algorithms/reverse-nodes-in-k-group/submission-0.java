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

        // split into different lists and create
        List<ListNode> lists = splitToLists(head, k);
        
        // reverse the lists
        List<ListNode> reversed = new ArrayList<>();
        for (int i = 0; i < lists.size(); i++) {
            if (remaining && i == lists.size() - 1) {
                reversed.add(lists.get(i));
            } else {
                reversed.add(reverseList(lists.get(i)));
            }
        }

        // concatenate the lists
        ListNode current = reversed.get(0);
        for (int i = 1; i < reversed.size(); i++) {
            current = concat(current, reversed.get(i));
        }

        return current;
    }

    public ListNode concat(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode current = list1;
        while (current.next != null) {
            current = current.next;
        }
        current.next = list2;
        return list1;
    }

    public ListNode reverseList(ListNode head) {
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

    private boolean remaining = false;

    public List<ListNode> splitToLists(ListNode head, int k) {

        List<ListNode> lists = new ArrayList<>();
        if (head == null) return lists;

        ListNode start = head;
        ListNode current = head;
        int count = 0;
        while (current != null) {
            count++;
            if (count == k) {
                lists.add(start);
                count = 0;
                ListNode temp = current.next;
                current.next = null;
                start = temp;
                current = temp;
            } else {
                current = current.next;
            }
        }

        if (start != null) {
            lists.add(start);
            remaining = true;
        }

        return lists;
    }
}
