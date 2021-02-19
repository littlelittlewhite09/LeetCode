/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //双端队列
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();//双端队列
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        queue.offer(root);
        int count = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for(int i = 0;i < size;i++){
                if(count % 2 == 1){
                    TreeNode node = queue.poll();
                    if(node.left!=null) queue.offer(node.left);
                    if(node.right!=null) queue.offer(node.right);
                    tmp.add(node.val);
                }else{
                    TreeNode node = queue.pollLast();
                    if(node.right!=null) queue.offerFirst(node.right);
                    if(node.left!=null) queue.offerFirst(node.left);
                    tmp.add(node.val);
                }
            }
            count++;
            res.add(tmp);
        }
        return res;
    }
}
