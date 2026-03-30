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


    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(0, 0, preorder.length - 1, preorder, inorder);
    }

    public TreeNode build(int index, int inL, int inR, int[] preorder, int[] inorder) {
        if (index >= preorder.length) return null;
        TreeNode node = new TreeNode(preorder[index]);
        int inorderIdx = map.get(preorder[index]);
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
}
