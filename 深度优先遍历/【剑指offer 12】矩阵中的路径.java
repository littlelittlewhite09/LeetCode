class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0;i < board.length;i++){
            for(int j = 0;j < board[0].length;j++){
                if(dfs(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    boolean dfs(char[][] board, String word, int i, int j, int k){
        if(i > board.length - 1 || i < 0 || j > board[0].length - 1 || j < 0 || board[i][j]!=word.charAt(k)) return false;
        if(k == word.length() - 1) return true;
        board[i][j] = '\0';//此处修改为空字符，放置下面深度遍历时又重新遍历该位置。等深度遍历完后，再还原为原来的字符
        boolean res = dfs(board, word, i+1, j, k+1) || dfs(board, word, i-1, j, k+1)
        || dfs(board, word, i, j-1,k+1) || dfs(board, word, i, j+1, k+1);
        board[i][j] = word.charAt(k);//还原为原来的字符
        return res;
    }
    
}
