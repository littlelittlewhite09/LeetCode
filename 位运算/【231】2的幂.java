class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        if (n == 1) return true;
        int temp = n % 2;
        if (temp == 0){
            return isPowerOfTwo(n>>1); //正数右移相当于除以2
        }else{
            return false;
        }

    }
}
