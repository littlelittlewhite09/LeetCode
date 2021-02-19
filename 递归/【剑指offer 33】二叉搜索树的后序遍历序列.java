class Solution {
    public boolean verifyPostorder(int[] postorder) {
        //对于二叉搜索树而言，中序遍历是确定的，因此只要直到前序遍历或后序遍历就能推导出树形结构
        int len = postorder.length;
        int p = len - 1;
        //当数组长度为0或1时直接返回true
        if(p==0) return true;
        if( p==-1) return true;

        int root = postorder[p];
        int l = -1,r = -1;//l表示根节点的左节点，r表示根节点的右节点
        if(postorder[--p] > root){//当倒数第二个结点大于根节点时，则该节点为右节点
            r = p;
            for(int i = r - 1;i >=0;i--){
                if(postorder[i] < root){
                    l = i;//找到根节点的左节点
                    break; 
                }
            }
            //若根节点的左节点不存在
            if(l == -1) return true&&verifyPostorder(Arrays.copyOfRange(postorder,0,len-1));
            //若左子树中有大于根节点的数直接返回false
            for(int i = 0;i < l+1;i++){
               if(postorder[i]>root) return false; 
            }
            //递归调用左右子树
            return true&&verifyPostorder(Arrays.copyOfRange(postorder,0,l+1))&&verifyPostorder(Arrays.copyOfRange(postorder,l+1,len-1));
        }else{//当倒数第二个结点小于根节点时，则根节点只有左子树
            //遍历左子树，若有大于根节点的数则直接返回false
            for(int i = 0;i < len;i++){
                if(postorder[i]>root) return false;
            }
            //递归调用左子树
            return true&&verifyPostorder(Arrays.copyOfRange(postorder,0,len-1));
        }
        
    }
    
}
