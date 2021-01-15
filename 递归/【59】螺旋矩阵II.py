import math
class Solution:
    def generateMatrix(self, n: int) -> List[List[int]]:
        res = [[ '_' for i in range(n)] for j in range(n)]
        def outracyFill(start = 1, layer = 1):
            '''
            start:从哪个数开始
            layer:生成第几圈
            '''
            if layer>math.ceil(n/2):
                return
            if start == n**2:
                res[n//2][n//2] = start
                return
            for i in range(layer-1,n-layer):
                res[layer-1][i] = start + i - layer + 1
                res[i][-layer] = start + n-2*layer + 1 + i - layer + 1
                res[-layer][i+1] = 3*(n-2*layer+1) + start -1 - (i - layer + 1)
                res[i+1][layer-1] = 4*(n-2*layer+1) + start- 1 - (i - layer + 1)
            
            start = 4*(n-2*layer+1) + start
            layer += 1
            outracyFill(start,layer)      
        outracyFill()
        return res
