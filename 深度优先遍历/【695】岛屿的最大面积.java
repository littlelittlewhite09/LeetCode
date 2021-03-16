class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int i = 0; i != grid.length; ++i) {
            for (int j = 0; j != grid[0].length; ++j) {
                ans = Math.max(ans, dfs(grid, i, j));
            }
        }
        return ans;
    }

    public int dfs(int[][] grid, int cur_i, int cur_j) {
        if (cur_i < 0 || cur_j < 0 || cur_i == grid.length || cur_j == grid[0].length || grid[cur_i][cur_j] == 0) {
            return 0;
        }
        grid[cur_i][cur_j] = 0; //此处为1，将其置0，表示这个位置来过
        int[] di = {0, 0, 1, -1};
        int[] dj = {1, -1, 0, 0};
        int ans = 1;
        for (int index = 0; index != 4; ++index) {
            //index=0:dj[0]=0,dj[0]=1,表示右移
            //index=1:dj[1]=0,dj[1]=-1,表示左移
            //index=2:dj[2]=1,dj[2]=0,表示下移
            //index=3:dj[3]=-1,dj[0]=0,表示上移移
            int next_i = cur_i + di[index], next_j = cur_j + dj[index];
            ans += dfs(grid, next_i, next_j);
        }
        return ans;
    }
}
