/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        return cutListNode(head, null);
    }

    public ListNode cutListNode(ListNode head, ListNode tail){
        if(head == null){
            return head;
        }
        if(head.next == tail){
            head.next = null;
            return head;
        }
        
        //快慢指针，快指针一次移动两个位置，慢指针一次移动一个位置。
        //当快指针到达最后一个位置时，慢指针则到达中间位置
        ListNode slow = head, fast = head;
        while (fast != tail){
            slow = slow.next;
            fast = fast.next;
            if (fast != tail){
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode listnode1 = cutListNode(head, mid);//该方法的作用就是将head与mid分割开来并取前面的一部分
        ListNode listnode2 = cutListNode(mid, tail);//listnode1不可能为空，但是listnode2是可以为空的
        return merge(listnode1,listnode2);

    }
    public ListNode merge(ListNode listnode1, ListNode listnode2){
        // if (listnode2 == null) return listnode1;
        ListNode tmp1 = listnode1, tmp2 = listnode2;
        ListNode sorted_res = new ListNode(0);
        ListNode tmp_res = sorted_res;
        while (tmp1 != null && tmp2 != null){
            if(tmp1.val <= tmp2.val){
                tmp_res.next = tmp1;
                if (tmp1!= null) tmp1 = tmp1.next;
                tmp_res = tmp_res.next;
            }else{
                tmp_res.next = tmp2;
                if (tmp2!= null) tmp2 = tmp2.next;
                tmp_res = tmp_res.next;
            }
        }
        tmp_res.next = (tmp1 != null)? tmp1:tmp2;
        return sorted_res.next;
    }
}
