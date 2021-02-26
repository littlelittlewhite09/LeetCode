class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int ans = 0;
        int Min = Integer.MAX_VALUE;
        for(int i = 0;i < prices.length;i++){
            // if(i == 0) ans = 0;
            if(prices[i]<Min) Min =prices[i];
            ans = Math.max(ans, prices[i]-Min);
        }
        return ans;
    }
}
