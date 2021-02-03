class Solution {
    public int[] exchange(int[] nums) {
       int left = 0;
       int right = nums.length-1;
       /*双指针
       （1）两个指针都指向奇数时，左指针右移，直到指向偶数，接着左右指针所指的数调换
       （2）两个指针都指向偶数时，同理
       */

       while(left<right){
           if (nums[left] % 2 == 1 && nums[right] % 2 == 1){
               left++;
           }else if(nums[left] % 2 == 0 && nums[right] % 2 == 0){
               right--;
           }else if(nums[left] % 2 == 1 && nums[right] % 2 == 0){
               left++;
               right--;
           }else{
                int tmp;
                tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right--;
           }
        }
        return nums;
    }
    
}
