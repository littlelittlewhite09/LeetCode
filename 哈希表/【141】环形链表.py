# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def hasCycle(self, head: ListNode) -> bool:
        # 基本思路：
        # 检查head.next的地址值是否出现过
        seen = []
        while head:
            if head in seen:
                return True
            seen.append(head) # 添加进去的其实是地址值
            head = head.next
            # print(seen)
        return False

