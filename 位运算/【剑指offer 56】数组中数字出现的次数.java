class Solution {
    public int[] singleNumbers(int[] nums) {
        int ret = 0;
        for (int n : nums) {
            ret ^= n;
        }
        //从右边开始，找到ret中第一个为1的位置
        //比如，当ret为101100时，则div = 4 = (100)_2
        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }
        int a = 0, b = 0;
        for (int n : nums) {
            int tmp=div & n;
            //若div与n的某一位是相同的，则tmp不可能为0
            if (tmp != 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};


    }
}
