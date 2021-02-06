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
    int res,k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        traver(root);
        return res;
    }

    //类似于中序遍历：右子树->根节点->左节点
    public void traver(TreeNode root){
        if(root == null) return;
        traver(root.right);
        if(--k == 0) res=root.val;
        traver(root.left);
    }
}
