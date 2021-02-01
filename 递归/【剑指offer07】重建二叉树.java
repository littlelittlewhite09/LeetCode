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
    private Map<Integer, Integer> map = new HashMap<>();;
    private int[] preorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        int pre_length = preorder.length;
        int in_length = inorder.length;
        if(pre_length == 0 || in_length == 0) return null;
        for(int i = 0;i < in_length;i++){
            map.put(inorder[i],i);
        }
        return buildTree(0, pre_length - 1, 0, in_length - 1);
    }
    public TreeNode buildTree(int preL, int preR, int inL, int inR){
        if(preL > preR || inL > inR) return null;
        TreeNode root = new TreeNode(preorder[preL]);
        int root_ind = map.get(preorder[preL]);
        root.left = buildTree(preL+1,preL+root_ind-inL,inL,root_ind-1);
        root.right = buildTree(preL + (root_ind - inL) + 1, preR,root_ind + 1, inR);
        return root;
    }
}
