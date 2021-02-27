class Solution {
    int ans = 0;
    public int translateNum(int num) {
        String s = String.valueOf(num);//将数转为字符串
        dfs(s);
        return ans;
    }
    //深度优先遍历
    void dfs(String s){
        if(s.length() <= 1){//当数为一位数时或没有空字符串时，则停止继续深度，同时ans+1
            ans++;
            return;
        }
        dfs(s.substring(1));//拿出第一个数字，对剩余的字符串进行递归

        //如果字符串的前两位数组成的数字小于26且第一个数字不能为0，例如"06"这种就是不合法的
        if(Integer.parseInt(s.substring(0,2)) <26&& s.charAt(0)!='0'){
            dfs(s.substring(2));
        }

    }
}
