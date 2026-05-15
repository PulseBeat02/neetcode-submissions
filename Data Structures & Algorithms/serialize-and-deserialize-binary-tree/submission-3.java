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
        StringBuffer sb = new StringBuffer();
        dfs(root, sb);
        String res = sb.toString();
        return res.substring(0, res.length() - 1);
    }

    public void dfs(TreeNode node, StringBuffer sb) {
        if (node == null) {
            sb.append("N");
            sb.append(",");
            return;
        }
        sb.append(node.val);
        sb.append(",");
        dfs(node.left, sb);
        dfs(node.right, sb);
    }

    int index = 0;

    public TreeNode deserialize(String data) {
        return deserialize(data.split(","));
    }

    public TreeNode deserialize(String[] data) {
        if (data[index].equals("N")) {
            index++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(data[index]));
        index++;
        node.left = deserialize(data);
        node.right = deserialize(data);
        return node;
    }
}





