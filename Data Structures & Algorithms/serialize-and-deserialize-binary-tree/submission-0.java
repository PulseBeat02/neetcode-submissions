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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        dfs(root, list);
        return String.join(",", list);
    }

    public void dfs(TreeNode root, List<String> sb) {
        if (root == null) {
            sb.add("N");
            return;
        }
        sb.add(String.valueOf(root.val));
        dfs(root.left, sb);
        dfs(root.right, sb);
    }

    int i = 0;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        return dfs0(split);
    }

    public TreeNode dfs0(String[] split) {
        if (split[i].equals("N")) {
            i++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(split[i]));
        i++;
        node.left = dfs0(split);
        node.right = dfs0(split);
        return node;
    }
}
