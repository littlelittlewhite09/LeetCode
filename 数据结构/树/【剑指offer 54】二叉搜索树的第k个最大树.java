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
    List<Integer> list = new ArrayList<>();
    public int kthLargest(TreeNode root, int k) {
        traver(root);
        int numsOfNode = list.size();
        return list.get(k-1);
    }

    //类似于中序遍历：右子树->根节点->左节点
    public void traver(TreeNode root){
        if(root == null) return;
        traver(root.right);
        list.add(root.val);
        traver(root.left);
    }
}
