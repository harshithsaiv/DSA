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
    public ListNode resList = new ListNode(0);
    public ListNode head = resList;
    public int carry =0;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = l1.val +l2.val+carry;
        carry = sum/10;
        resList.next = new ListNode(sum%10);
        resList = resList.next;
        
        if(l1.next!=null && l2.next!=null)
            addTwoNumbers(l1.next,l2.next);
        else if(l1.next==null && l2.next!=null)
            addTwoNumbers(new ListNode(0),l2.next);
        else if(l1.next!=null && l2.next==null)
            addTwoNumbers(l1.next,new ListNode(0));
        else if(carry>0){
            resList.next = new ListNode(1);
            resList = resList.next;
        }
        return head.next;
    }
}