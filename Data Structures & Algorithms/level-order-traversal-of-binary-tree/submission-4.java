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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        final List<List<Integer>> ans = new ArrayList<>();
        final Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            final List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode pop = queue.poll();
                level.add(pop.val);
                if (pop.left != null) queue.add(pop.left);
                if (pop.right != null) queue.add(pop.right);
            }
            ans.add(level);
        }

        return ans;
    }
}
