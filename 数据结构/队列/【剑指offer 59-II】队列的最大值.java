class MaxQueue {

    //维护一个单调递减队列（严格地讲，应该是单调不递增）
    //这个队列的队首(peek)就是最大值
    private ArrayDeque<Integer> queue;
    private ArrayDeque<Integer> helper;
    public MaxQueue() {
        queue = new ArrayDeque<>();
        helper = new ArrayDeque<>();
    }
    
    public int max_value() {
        if(queue.size() == 0) return -1;
        return helper.peek();
    }
    
    public void push_back(int value) {
        while (!helper.isEmpty() && helper.peekLast() < value) {
            helper.pollLast();
        }
        queue.offer(value);
        helper.offer(value);
    }
    
    public int pop_front() {
        if(queue.size() == 0) return -1;
        int tmp = queue.pop();
        if(tmp == helper.peek()){
            helper.pop();
        }
        return tmp;
    }
}
/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
