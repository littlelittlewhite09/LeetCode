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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int l_depth = depth(root.left);
        int r_depth = depth(root.right);
        if(Math.abs(l_depth-r_depth)<=1){
            boolean leftIsBalanced = isBalanced(root.left);
            boolean rightIsBalanced = isBalanced(root.right);
            return leftIsBalanced&&rightIsBalanced;//当左右子树都为平衡树，则该树才为平衡树
        }
        return false; //不满足左右子树深度相差1，则返回false
    }


    //求树的深度
    public int depth(TreeNode root){
        if(root == null) return 0;
        return Math.max(depth(root.left),depth(root.right))+1;
    }
}
