class Solution {
    public int climbStairs(int n) {
    //动态规划
    /*对于n阶台阶，记有f(n)种方法。从两个方向进行考虑：
    (1)从n-1号台阶上跨一个台阶上来；
    (2)从n-2号台阶上跨两个台阶上来。
    因此，f(n) = f(n-1) + f(n-2)
    */
    if (n == 1) return 1;
    if (n == 2) return 2;
    int tmp1 = 1;
    int tmp2 = 2;
    int tmp=0;
    for(int i=3; i <= n; i++){
        tmp = tmp1 + tmp2;
        tmp1 = tmp2;
        tmp2 = tmp;
    }
    return tmp;
    }
}
