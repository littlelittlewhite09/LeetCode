/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//  https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/solution/mian-shi-ti-28-dui-cheng-de-er-cha-shu-di-gui-qing/
class Solution {
    public boolean isSymmetric(TreeNode root) {
       return (root == null)? true:isSymmetric(root.left,root.right);
    }

    public boolean isSymmetric(TreeNode L, TreeNode R){
        if(L == null && R == null) return true;
        if(L == null || R == null || L.val != R.val) return false;
        return isSymmetric(L.left,R.right) && isSymmetric(L.right,R.left);
     }
}
