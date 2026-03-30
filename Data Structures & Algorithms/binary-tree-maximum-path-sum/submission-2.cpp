/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */

class Solution {
public:

    int max = INT_MIN;

    int maxPathSum(TreeNode* root) {
        maxSum(root);
        return max;
    }

    int maxSum(TreeNode* root) {
        if (!root) return 0;
        int left = std::max(0, maxSum(root->left));
        int right = std::max(0, maxSum(root->right));
        max = std::max(max, left + right + root->val);
        return root->val + std::max(left, right);
    }
};
