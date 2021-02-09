class Solution {
    public int integerBreak(int n) {
        //动态规划（dynamitc planning）
        /*对于第i个数，记它的乘积最大值为dp[i].dp[0]=dp[1]=0
        第i个数可以分为两个数：j和i-j。若j固定，则在此约束下，最大乘积为max(j(i-j),j*dp[i-j]).
        所以可以遍历所有j，得出每个j对应的最大值，再综合取最大得到最终结果。
        */
        int[] dp = new int[n+1];
        for(int i = 2;i < n+1;i++){
            int curMax = 0;
            for(int j = 0;j < i;j++){
                curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }
}
