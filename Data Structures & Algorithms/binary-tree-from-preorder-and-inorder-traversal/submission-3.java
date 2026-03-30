/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, preorder.length - 1, 0);
    }

    public TreeNode build(int[] preorder, int[] inorder, int left, int right, int index) {
        if (index >= preorder.length) return null;
        TreeNode node = new TreeNode(preorder[index]);
        int find = -1;
        for (int i = left; i <= right; i++) {
            if (inorder[i] == preorder[index]) {
                find = i;
                break;
            }
        }
        int countLeft = find - left;
        int countRight = right - find;
        if (countLeft > 0) {
            node.left = build(preorder, inorder, left, find - 1, index + 1);
        }
        if (countRight > 0) {
            node.right = build(preorder, inorder, find + 1, right, index + 1 + countLeft);
        }
        return node;
    }
}
