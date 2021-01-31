class Solution {
    public int findRepeatNumber(int[] nums) {
        // //方法一：双指针遍历，时间复杂度O(n^2)
        // for(int i = 0;i < nums.length;i++){
        //     for(int j = i + 1; j < nums.length;j++){
        //         if(nums[i] == nums[j]) return nums[i];
        //     }
        // }
        // throw new RuntimeException("没有找到");
        //方法二：集合
        Set<Integer> set = new HashSet<>();
        boolean flag = true;//判断是否添加成功
        int res = -1;
        for(int i = 0;i < nums.length && flag;i++){
            flag = set.add(nums[i]);
            if(!flag){
                res = nums[i];
            }
        }
        return res;
    }
}
