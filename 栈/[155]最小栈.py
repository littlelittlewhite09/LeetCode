class MinStack:
    # 创建辅助栈
    # 用以存储栈以下的最小值

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.helper_stack = [math.inf]


    def push(self, x: int) -> None:
        self.stack.append(x)
        self.helper_stack.append(min(x,self.helper_stack[-1]))

    def pop(self) -> None:
        self.stack.pop()
        self.helper_stack.pop()
    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.helper_stack[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
