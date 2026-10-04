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

    int max = Integer.MIN_VALUE;
    Map<TreeNode, Integer> cache = new HashMap<>();

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max; 
    }

    private int getMax(TreeNode root) {
        if (root == null) return 0;
        if (cache.containsKey(root)) return cache.get(root);
        int left = getMax(root.left);
        int right = getMax(root.right);
        int sum = root.val + Math.max(left, right);
        int res = Math.max(sum, 0);
        cache.put(root, res);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        int left = getMax(root.left);
        int right = getMax(root.right);
        max = Math.max(max, left + right + root.val);
        dfs(root.left);
        dfs(root.right);
    }
}
