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

// ->A->B->C->D
// <-A B->C->D
// <-A<-B C->D
// <-A<-B<-C D

// 1) current head
// 2) prev = null
// while (current != null)
//   ListNode temp = current.next;
//   current.next = prev;
//   prev = current;
//   current = temp;
// return prev

class Solution {
    public ListNode reverseList(ListNode head) {
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
