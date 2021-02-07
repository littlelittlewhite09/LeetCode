class Solution {
    public String reverseWords(String s) {
        String tmp = s.trim();//去除两端的空白
        int len = tmp.length();
        Deque<String> res = new ArrayDeque<String>();//创建队列
        int head=0;
        boolean flag = false;//判断是否正在读字符
        for(int i = 0;i < len;i++){
            if(tmp.charAt(i) == ' ' && flag){
                String sub = tmp.substring(head,i);
                res.offerFirst(sub);//在队列的头部添加元素
                flag = false;
            }else if(tmp.charAt(i) != ' ' && !flag){
                head = i;
                flag = true;
            }
            if(i == len - 1){
                res.offerFirst(tmp.substring(head,i+1));
            }
        }
        return String.join(" ",res);//连接
    }
}
