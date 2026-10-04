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

    public void dfs(TreeNode root, List<String> list) {
        if (root == null) {
            list.add("N");
            return;
        }
        list.add(String.valueOf(root.val));
        dfs(root.left, list);
        dfs(root.right, list);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        dfs(root, list);
        return String.join(",", list);
    }

    // [1,2,null,null,3,4,null,null,5,null,null]

    int index = 0;

    public TreeNode decode(String[] list) {
        if (list[index].equals("N")) return null;
        String raw = list[index];
        TreeNode node = new TreeNode(Integer.parseInt(raw));
        index++;
        node.left = decode(list);
        index++;
        node.right = decode(list);
        return node;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return decode(data.split(","));
    }
}
