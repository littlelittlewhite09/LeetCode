/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 /*
 若一个节点为公共的父节点，则必为以下两种情况：
 (1)该节点的左右子树分别含有p和q
 (2)该节点就是p(或q)，q(或p)在该节点的子树中

 一棵树如果含有p或q，则有以下两种情况
 (1)子树中含有p或q
 (2)根节点就是p或q
 */
class Solution {
    TreeNode res = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findNode(root,p,q);
        return res;
    }

    public boolean findNode(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return false;
        boolean left = findNode(root.left, p, q); //判断左子树是否含有p或q
        boolean right = findNode(root.right, p, q); //判断右子树是否含有p或q
        if((left && right) || (root == p && (left||right)) || (root == q && (left||right))){//该节点为公共父节点的所有情况
            res = root;
        }
        return (left || right) || (root == p) || (root == q);//判断以root为根节点的树是否含有p或q
    }
}
