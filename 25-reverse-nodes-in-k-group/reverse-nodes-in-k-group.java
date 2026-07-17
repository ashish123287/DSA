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
    public ListNode reverse(ListNode ptr2, ListNode ptr){
        ListNode prev = null;
        ListNode ptr3 = ptr2.next;
        while(ptr2 != ptr){
            ptr2.next = prev;
            prev = ptr2;
            ptr2 = ptr3;
            if (ptr3 != null) ptr3 = ptr3.next; 
        }
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1) return head;
        ListNode last = new ListNode(-1);  // this is dummy last
        ListNode fakeHeader = last;

        ListNode prev = head;
        ListNode ptr = head;

        while(ptr != null){
            int count = 0;
            ListNode ptr2 = ptr;
            ListNode temp = ptr2;
            while(ptr != null && count != k){
                count++;
                ptr = ptr.next;
            }
            if(count == k) prev = reverse(ptr2, ptr);
            else {
                last.next = ptr2;
                break;
            }
            last.next = prev;
            last = temp;
        }
        return fakeHeader.next;
    }
}