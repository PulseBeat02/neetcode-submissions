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
        
        // get LinkedList length
        int size = 0;
        for (ListNode* node = head; node; node = node->next) {
            size++;
        }

        // get prev node
        ListNode* prev = head;
        int index = 0;
        int target = size - n - 1;
        while (index < target) {
            prev = prev->next;
            index++;
        }

        // detach
        if (target == -1) {
            return head->next;
        }
        prev->next = prev->next->next;
    
        return head;

    }
};
