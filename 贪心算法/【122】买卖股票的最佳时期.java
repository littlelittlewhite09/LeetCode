class Solution {
    public int maxProfit(int[] prices) {
        /*贪心算法
        第l天买入，第r天卖出(不考虑中间的买入卖出)，则赚price[r]-price[l]
        =(price[r]-price[r-1])+(price[r-1]-price[r-2])……+(price[l+1]-price[l])
        将其中小于0的部分置成0
        ans = sum(max(0, prices[i] - prices[i - 1]))
        */

        int ans = 0;
        int n = prices.length;
        for (int i = 1; i < n; ++i) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }
}
