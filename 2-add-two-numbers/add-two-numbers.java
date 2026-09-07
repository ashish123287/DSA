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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         ListNode temp1 = l1;
         ListNode temp2 = l2;
         int s1 = 0;
         int s2 = 0;
         while(temp1 != null){
            s1++;
            temp1 = temp1.next;
         }
         while(temp2 != null){
            s2++;
            temp2 = temp2.next;
         }
         if(s1 > s2){
            temp1 = l1;
            temp2 = l2;
         } else{
            temp1 = l2;
            temp2 = l1;
         }
         ListNode head = temp1;
         int carry = 0;
         while(temp1 != null){
            if(temp2 != null){
                int a = temp1.val + temp2.val + carry;
                temp1.val = a%10;
                carry = a/10;
                if(temp1.next == null) break;
                temp1 = temp1.next;
                temp2 = temp2.next;
            } else {
                int a = temp1.val + carry;
                temp1.val = a%10;
                carry = a/10;
                if(temp1.next == null) break;
                temp1 = temp1.next;
            }

         }

         if(carry != 0){
            ListNode a = new ListNode(carry);
            temp1.next = a;
         }
         return head;
    }
}