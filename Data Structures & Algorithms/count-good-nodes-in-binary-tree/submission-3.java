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
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    public int dfs(TreeNode root, int max) {
        if (root == null) return 0;
        int res = root.val < max ? 0 : 1;
        int newMax = Math.max(root.val, max);
        res += dfs(root.left, newMax);
        res += dfs(root.right, newMax);
        return res;
    }
}
