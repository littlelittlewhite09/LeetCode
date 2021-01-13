class Solution {
    public int maxSubArray(int[] nums) {
        //动态规划
        /**
        以第i个位置结尾的最大值记为f(i)，那么第i+1个位置结尾的最大值f(i+1)=max{a_i+1,f(i)+a_i+1}
        */
        if (nums.length==1){
            return nums[0];
        }
        int  max = 0;
        int maxAns = nums[0];
        for (int i=0; i < nums.length; i++){
            max = Math.max(nums[i],nums[i]+max);
            maxAns = Math.max(maxAns, max);
        }
        return maxAns;
    }
}
