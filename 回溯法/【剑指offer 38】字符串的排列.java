class Solution {
    List<String> ans = new ArrayList<>();
    Set<String> set = new HashSet<>();
    String res = "";
    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        LinkedList<Character> list = new LinkedList<>();
        for(char c:chars){
            list.add(c);
        }
        backtracked("",list);
        return ans.toArray(new String[ans.size()]);
    }
    void backtracked(String s, List list){
        int len = list.size();
        if(len == 1){
            String tmp = res + list.get(0);
            if(!set.contains(tmp)){
                ans.add(tmp);
                set.add(tmp);
            }
            res = "";
            return;
        }
        for(int i = 0;i < len;i++){
            char tmp = (Character)list.get(i);
            res = s + tmp;
            list.remove(i);
            backtracked(res,list);
            list.add(i,tmp);
        }
        
    }
}
