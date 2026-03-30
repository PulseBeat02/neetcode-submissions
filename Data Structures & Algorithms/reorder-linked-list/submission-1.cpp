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
    void reorderList(ListNode* head) {
        // Get middle
        ListNode* middle = head;
        ListNode* fast = head;
        while (fast && fast->next) {
            middle = middle->next;
            fast = fast->next->next;
        }

        // Reverse second part
        ListNode* second = nullptr;
        ListNode* current = middle->next;
        middle->next = nullptr;
        while (current) {
            ListNode* temp = current->next;
            current->next = second;
            second = current;
            current = temp;
        }

        // Zig zag
        ListNode* first = head;
        while (first && second) {
            ListNode* tmp1 = first->next;
            ListNode* tmp2 = second->next;
            first->next = second;
            second->next = tmp1;
            first = tmp1;
            second = tmp2;
        }
    }
};
