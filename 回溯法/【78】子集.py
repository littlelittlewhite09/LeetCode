class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []
        n = len(nums)
        def helper(i, tmp):
            res.append(tmp)
            for j in range(i, n):
                helper(j + 1,tmp + [nums[j]] )
        helper(0, [])
        return res

        
# 回溯法一般的代码模板
# private void backtrack("原始参数") {
#     //终止条件(递归必须要有终止条件)
#     if ("终止条件") {
#         //一些逻辑操作（可有可无，视情况而定）
#         return;
#     }

#     for (int i = "for循环开始的参数"; i < "for循环结束的参数"; i++) {
#         //一些逻辑操作（可有可无，视情况而定）

#         //做出选择

#         //递归
#         backtrack("新的参数");
#         //一些逻辑操作（可有可无，视情况而定）

#         //撤销选择
#     }
# }
