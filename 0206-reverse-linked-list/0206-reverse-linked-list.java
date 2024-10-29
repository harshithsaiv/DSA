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
    public ListNode reverseList(ListNode head) {
        Stack<Integer> s = new Stack<>();
        while(head!=null){
            s.add(head.val);
            head= head.next;
        }
        ListNode h=null;
        
        while(!s.isEmpty()){
            ListNode temp = new ListNode(s.pop());
            if(h==null)
                h=temp;
            else{
                ListNode t = h;
                while(t.next!=null){
                    t=t.next;
                }
                t.next=temp;
            }
        }
        return h;
    }
}