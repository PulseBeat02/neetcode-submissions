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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true;
        if (root == null && subRoot != null) return false;
        if (isSameTree(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    Map<TreeNode, Map<TreeNode, Boolean>> map = new HashMap<>();

    public boolean isSameTree(TreeNode first, TreeNode second) {
        if (first == null && second == null) return true;
        if (first != null && second == null) return false;
        if (first == null && second != null) return false;
        Map<TreeNode, Boolean> cache = map.get(first);
        if (cache != null && cache.containsKey(second)) return cache.get(second);
        boolean res = first.val == second.val && isSameTree(first.left, second.left) && isSameTree(first.right, second.right);
        map.computeIfAbsent(first, k -> new HashMap<>()).put(second, res);
        return res;
    }
}
