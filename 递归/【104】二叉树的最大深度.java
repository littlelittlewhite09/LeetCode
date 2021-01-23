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
    public int maxDepth(TreeNode root) {
        /*方法：递归
        一个树的深度 = max{左子树深度，右子树深度}+1
        */
        if (root == null) return 0;
        if (root.left == null && root.right == null){
            return 1;
        }else if (root.left == null && root.right != null){
            return 1 + maxDepth(root.right);
        }else if (root.left != null && root.right == null){
            return 1 + maxDepth(root.left);
        }
        return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}
