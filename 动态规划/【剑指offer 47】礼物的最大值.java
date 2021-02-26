class Solution {
    public int maxValue(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for(int i = 0;i < dp.length;i++){
            for(int j = 0;j < dp[0].length;j++){
                if(i == 0){
                    if(j+1<dp[0].length){
                        dp[i][j+1] = dp[i][j]+grid[i][j+1];
                        continue;
                    }
                    break;
                }
                if(j == 0){
                    dp[i][j]=dp[i-1][j]+grid[i][j];
                    continue;
                }

                dp[i][j] = Math.max(dp[i-1][j]+grid[i][j],dp[i][j-1]+grid[i][j]);   
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
}
