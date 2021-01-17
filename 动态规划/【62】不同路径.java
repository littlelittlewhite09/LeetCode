class Solution {
    public int uniquePaths(int m, int n) {
        /*动态规划
        假设从起始位置到第(i,j)位置，路线条数记为f(i,j)，
        而到达该位置只能是从(i-1,j)下移一个位置或是从(i,j-1)左移一个位置，
        所以，有f(i,j)=f(i-1,j)+f(i,j-1).

        一些细节：
        根据机器人运动规则（只能向下或向下运动），所以到达最上面位置只能有一条路径，同理最左侧只能有一条路径。
        */

        if (m == 1 && n == 1) return 1;
        int[][] f = new int[m][n];
        for(int i = 0; i < m;i++){
            f[i][0] = 1;
        }
        for(int i = 0;i < n;i++){
            f[0][i] = 1;
        }
        for(int i = 1; i < m;i++){
            for(int j = 1; j < n; j++){
                f[i][j]=f[i-1][j]+f[i][j-1];
            }
        }
        return f[m-1][n-1];
    }
}
