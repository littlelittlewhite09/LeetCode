class Solution {
    public double myPow(double x, int n) {
        long tmp = n;//出现大数时，可考虑转为long型
        double res = 1.0;
        if(tmp < 0){
            tmp = -tmp;
            x = 1 / x;
        }
        while(tmp > 0){
            if((tmp & 1) == 1){//判断二进制最后一位是否为1，也就是判断tmp是否为奇数
                res *= x;
            }
            x *= x;
            tmp >>= 1;//相当于整除2
        }
        return res;
    }
}
