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

    // pre: [root | left | right]
    //  in: [left | root | right]

    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) return null;
        int rootVal = preorder[preLeft];
        int find = map.get(rootVal);
        int leftSize = find - inLeft;
        TreeNode node = new TreeNode(rootVal);
        node.left = build(
            preorder,
            preLeft + 1,
            preLeft + leftSize,
            inLeft,
            find - 1
        );
        node.right = build(
            preorder,
            preLeft + leftSize + 1,
            preRight,
            find + 1,
            inRight
        );
        return node;
    }
}
