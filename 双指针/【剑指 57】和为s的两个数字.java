class Solution {
    public int[] twoSum(int[] nums, int target) {
        //双指针 一个指针在数组头部，一个在尾部
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        boolean flag = false;
        int[] res = new int[2];
        while(!flag){
           if(nums[left]+nums[right]<target){
               left++;
            }else if(nums[left]+nums[right]>target){
                right--;
            }else{
                res[0] = nums[left];
                res[1] = nums[right];
                flag = true;
            }
        }
        return res;
    }
}
