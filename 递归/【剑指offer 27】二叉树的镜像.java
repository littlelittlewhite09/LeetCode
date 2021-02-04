/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null) return root;

        //交互左右子树
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        //递归
        root.left = mirrorTree(root.left);
        root.right = mirrorTree(root.right);
        return root;
    }
}
