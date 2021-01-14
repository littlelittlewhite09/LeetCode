class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        '''
        方法：递归；
        终止条件：矩阵为空，或矩阵内部的行元素位空时
        思路：递归调用最外圈的数组
        '''
        res = []
        def recurrent(matrix = matrix):
            if not matrix or not matrix[0]:
                return 
            m = len(matrix)
            n = len(matrix[0])
            if m == 1:
                    res.extend(matrix[0]) # 注意： 只能使用res.extend或res.append,不能使用res += matrix[0],会报错
            elif n == 1:
                for x in matrix:
                    res.extend(x)              
            else:
                res.extend(matrix[0][:n-1])
                tmp1 = []
                for i in range(m-1):
                    tmp1.append(matrix[i][-1])
                res.extend(tmp1)
                res.extend(matrix[-1][1:][::-1])
                tmp2 = []
                for i in range(m-1,0,-1):
                    tmp2.append(matrix[i][0])
                res.extend(tmp2)
                recurrent([matrix[i][1:-1] for i in range(1,m-1)])
                
        recurrent(matrix)
        return res
