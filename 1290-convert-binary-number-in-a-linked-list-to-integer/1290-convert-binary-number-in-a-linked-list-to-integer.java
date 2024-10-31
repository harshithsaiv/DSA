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
    public int getDecimalValue(ListNode head) {
        String s ="";
        while(head!=null){
            s=s+head.val;
            head = head.next;
        }
        
        int res=0;
        int j=0;
        for(int i=s.length()-1;i>=0;i--,j++){
            char ch = s.charAt(i);
            int x = ch-'0';
            int value = x*(int)Math.pow(2,j);
            res+=value;
        }
        return res;
    }
}