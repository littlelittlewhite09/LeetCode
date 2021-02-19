class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int len = pushed.length;
        if(len == 0) return true;
        Stack<Integer> stack = new Stack<>();
        int j = 0;//用来指向pushed中的元素
        for(int i = 0;i < len;i++){
            if(stack.isEmpty()){//当stack为空时，stack.peek()会报错，所以判断是否为空，若为空，添加元素
                stack.push(pushed[j]);
                j++;
            }
            while(stack.peek()!=popped[i]){//当栈顶与待弹出的元素不等时，继续压栈，直至栈顶与待弹出元素相等
                if(j >= len) return false;//当指针j超出len时，即为false
                stack.push(pushed[j]);
                j++;
            }
            stack.pop();//此时栈顶与待弹出元素相等，弹出栈顶
        }
        return true;
    }
}
