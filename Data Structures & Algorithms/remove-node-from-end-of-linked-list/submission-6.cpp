/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */

class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        
        // get size
        int size = 0;
        for (ListNode* current = head; current; current = current->next) size++;

        // iterate to element
        int target = size - n;
        if (target == 0) {
            return head->next;
        }

        int index = 0;
        ListNode* deleteNext = head;
        while (index < target - 1) {
            deleteNext = deleteNext->next;
            index++;
        }

        // delete
        ListNode* next = deleteNext->next;
        if (next) {
            deleteNext->next = next->next;
        } else {
            deleteNext->next = nullptr;
        }

        return head;
    }
};
