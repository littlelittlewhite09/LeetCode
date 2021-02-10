class Solution {
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n-1;
        }

        /*
            据 数学证明：
            当 n >= 3时，因数 拆分成 3 的计算结果 较大
            当 n < 3时，因数越大，计算结果越大
        */
        int threadhold = 1000000007;
        long result = 1L;
        while (n > 4) {
            result = result * 3 % threadhold;
            n -= 3;
        }

        /*
            将 最后一个 因数 计算在内
        */
        result = result * n % threadhold;

        return (int)result;
    }
}
