class Solution {
    public int numWays(int n) {
        if(n == 0) return 1;
        int[] num = new int[2];
        num[0] = 1;
        num[1] = 2;
        int i = 0;
        while(i < n - 2){
            num[0] = (num[0] + num[1]) % 1000000007;
            i++;
            if(i < n - 2){
                num[1] = (num[0] + num[1]) % 1000000007;
                i++;
            }
        }
        return ((n-2)%2==0)? num[1]:num[0];
    }
}
