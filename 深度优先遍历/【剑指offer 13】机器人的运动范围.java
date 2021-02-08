class Solution {

    //这是一道搜索的题目，对于搜索应该想到深度优先遍历或是广度优先遍历
    //本次使用深度优先遍历，对于深度优先遍历，应该使用递归
    private  boolean[][] visited;//用以存储各个位置是否被访问过
    int m,n;
    public int movingCount(int m, int n, int k) {
        visited = new boolean[m][n];
        this.m = m;
        this.n = n;
        return dfs(k, 0, 0);
    }

    private int dfs(int k, int i, int j) {
        if(i >= m || j >= n || visited[i][j] || i/10+i%10+j/10+j%10 > k) return 0;
        visited[i][j] = true;
        return 1 + dfs(k, i + 1, j) + dfs(k,i, j + 1) ;
    }
}
