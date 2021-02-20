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
    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root,sum);
        return res;
    }
    void dfs(TreeNode root, int target){
        if(root == null) return;
        path.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null){
            /*注意：这里不能写成res.add(path).
            因为这样只是将path的地址添加至res，而path后面因为回溯，会变动，也会改变res
            */
            res.add(new LinkedList(path));//这里可以理解为重新复制了一份path
        }
        dfs(root.left,target);
        dfs(root.right,target);
        path.removeLast();
    }

}
