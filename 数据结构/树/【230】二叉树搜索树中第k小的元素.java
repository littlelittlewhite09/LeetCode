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
/*深度优先遍历：
（1）前序遍历：根节点->左子树->右子树
（2）中序遍历：左子树->根节点->右子树
（3）后续遍历：左子树->右子树->根节点

注意点：对于一个二叉搜索树而言，中序遍历就是从小到大输出
*/


class Solution {
    List<Integer> list = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        midOrder(root);
        return list.get(k-1);
    }

    public void midOrder(TreeNode root){
        if(root == null) return;
        midOrder(root.left);
        list.add(root.val);
        midOrder(root.right);
    }
}
