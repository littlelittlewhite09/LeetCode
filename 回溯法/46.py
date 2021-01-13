'''
这题可看作是深度优先遍历，对于深度优先遍历，可使用的方法有：栈，递归
'''

class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        res = []
        def backtrace(path=[], left = nums):
            if not left:
                res.append(path[:])
                return 
            for i in range(len(left)):
                path.append(left[i]) 
                backtrace(path, left[:i]+left[i+1:]) # 里面的path都是局部变量了，不会影响外面的path
                path.pop() # 弹出父节点
        backtrace()
        return res
