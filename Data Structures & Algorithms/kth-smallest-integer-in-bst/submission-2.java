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
    public int kthSmallest(TreeNode root, int k) {
        List<TreeNode> list = new ArrayList<>();
        dfs(root, list);
        return list.get(k - 1).val;
    }

    public void dfs(TreeNode root, List<TreeNode> order) {
        if (root == null) return;
        dfs(root.left, order);
        order.add(root);
        dfs(root.right, order);
    }
}
