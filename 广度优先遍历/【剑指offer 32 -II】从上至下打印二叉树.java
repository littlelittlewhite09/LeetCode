/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 //广度优先搜索
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    Queue<TreeNode> queue = new ArrayDeque<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return res;
        }
        queue.add(root);//根节点入队
        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();//用来盛放每层的节点
            int len = queue.size();//获取当前层级的节点数
            for(int i = 0; i < len;i++){//上级节点挨个出队，同时父节点的子节点入队
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            res.add(level);
        }
        return res;
    }
}
