/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {

        //方法一：哈希表，算法时间复杂度：O(n)
        if(head == null) return null;
        boolean flag = true;
        HashSet<ListNode> set = new HashSet<>();
        while (flag){
            if(head.next == null) {
                set.add(head);
                break;
            }else{
                flag = set.add(head);
                if(flag){
                    head = head.next;
                }else{
                    return head;
                }   
            }
        }
        return null;
    }
}
