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
        return build(0, 0, preorder.length - 1, preorder, inorder);
    }

    public TreeNode build(int index, int inL, int inR, int[] preorder, int[] inorder) {
        if (index >= preorder.length) return null;
        TreeNode node = new TreeNode(preorder[index]);
        int inorderIdx = search(inorder, node.val, inL, inR);
        int left = inorderIdx - inL;
        int right = inR - inorderIdx; 
        if (left > 0) {
            node.left = build(index + 1, inL, inorderIdx - 1, preorder, inorder);
        }
        if (right > 0) {
            node.right = build(index + 1 + left, inorderIdx + 1, inR, preorder, inorder);
        }
        return node;
    }

    public int search(int[] inorder, int root, int left, int right) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root) {
                return i;
            }
        }
        return -1;
    }
}
