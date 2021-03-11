/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    String ans = "[";
    TreeNode root;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return ans+"]";
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        ans = ans + root.val + ",";
        while(!list.isEmpty()){
            TreeNode node = list.poll();
            if(node.left!=null){
                list.add(node.left);
                ans= ans +node.left.val + "," ;
            }else{
                ans= ans +null + ",";
            }
            if(node.right!=null){
                list.add(node.right);
                ans= ans +node.right.val + ",";
            }else{
                ans= ans +null + ",";
            }
        }
        while(ans.endsWith("null,")){
            ans = ans.substring(0,ans.length()-5);
        }
        // System.out.print(ans.substring(0,ans.length()-1)+"]");
        return ans.substring(0,ans.length()-1)+"]";

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==2) return null;
        data = data.substring(1,data.length()-1);
        String[] vals = data.split(",");
        System.out.print(vals.length);
        root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue = new LinkedList<>() {{ add(root); }};
        int i = 1;
        while(!queue.isEmpty() && i < vals.length) {
            TreeNode node = queue.poll();
            if(!vals[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.left);
            }
            i++;
            if(i >= vals.length) break;
            if(!vals[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
