/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// 二叉搜索树(Binary Search Tree)，又名二叉排序树(Binary Sort Tree)。
//   二叉搜索树是具有有以下性质的二叉树：
//   （1）若左子树不为空，则左子树上所有(注意是所有)节点的值均小于或等于它的根节点的值。
//   （2）若右子树不为空，则右子树上所有(注意是所有)节点的值均大于或等于它的根节点的值。
//   （3）左、右子树也分别为二叉搜索树。

// 如果两个节点值都小于根节点，说明他们都在根节点的左子树上，我们往左子树上找
// 如果两个节点值都大于根节点，说明他们都在根节点的右子树上，我们往右子树上找
// 如果一个节点值大于根节点，一个节点值小于根节点，说明他们他们一个在根节点的左子树上一个在根节点的右子树上，那么根节点就是他们的最近公共祖先节点
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if ((root.val- p.val)*(root.val- q.val) <= 0) {
            return root;
        }else if (root.val- p.val > 0 && root.val- q.val > 0){
            return lowestCommonAncestor(root.left,p,q);
        }else{
            return lowestCommonAncestor(root.right,p,q);
        }

    }
}
