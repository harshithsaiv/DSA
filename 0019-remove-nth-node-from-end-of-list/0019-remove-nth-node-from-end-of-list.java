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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len =0;
        ListNode curr = head;
        while(curr!=null){
            len+=1;
            curr = curr.next;
        }
       
        if(len==1){
            return null;
        }
        
        if(n==len){
            head=head.next;
            return head;
        }
        
        curr=head;
        if(n==1){
            int count=1;
            while(count<=len){
                if(count==len-1){
                    curr.next=null;
                }
                count++;
                if(count<len)
                    curr=curr.next;
            }
            return head;
        }
        
        curr = head;
        ListNode prev=null;
        ListNode next=null;
        int count=1;
        System.out.println(len);
        while(count<=len){
            if(count==(len-n)&&(len-n+2)>=0){
                prev=curr;
            }
            if(count==(len-n+2)&& (len-n+2)<=len){
                next=curr;
            }
           
            if(count<len)
                curr=curr.next;
             count++;
             System.out.println();
        }
        System.out.println(prev.val);
        System.out.println(next.val);
        prev.next=next;
        return head;
    }
}