class Solution {
    public int lengthOfLongestSubstring(String s) {
        //动态规划:dp[i]表示s中以第i个字符为结尾的最长不重复子串
        //
        Map<Character,Integer> map = new HashMap<>();
        int ans=0,tmp=0;
        for(int i = 0;i < s.length();i++){
            int j = map.getOrDefault(s.charAt(i),-1);//获取哈希表中键s.charAt(i)所对应的索引值,若不存在则返回-1
            map.put(s.charAt(i),i);
            tmp = i-j>tmp? tmp+1:i-j;
            ans = Math.max(tmp,ans);
        }
        return ans;  
    }
}
