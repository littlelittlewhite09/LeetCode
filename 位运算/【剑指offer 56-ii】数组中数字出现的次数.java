class Solution {
    public int singleNumber(int[] nums) {
        //该方法具有通用性，对于一个数字中，有若干数字出现了m次，而只有一个数字出现一次，都可以使用该方法。
        int[] counts = new int[32];//记录每个位1出现的次数
        for(int num : nums) {
            for(int j = 0; j < 32; j++) {
                counts[j] += num & 1; // 判断最后一位是不是为1
                num >>>= 1;//无符号右移
            }
        }
        int res = 0, m = 3;
        for(int i = 0; i < 32; i++) {
            res <<= 1;
            res |= counts[31 - i] % m;
        }
        return res;
    }
}
