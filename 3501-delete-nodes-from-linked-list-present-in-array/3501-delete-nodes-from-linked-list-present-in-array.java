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
    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        Set<Integer> check = new HashSet<>();
        for(int num :nums){
            check.add(num);
        }

        ListNode curr = new ListNode();
        ListNode prev = new ListNode();
        curr = head;
        prev = dummy;

        while(curr!=null){
            int val = curr.val;
            if(check.contains(val)){
                prev.next = curr.next;
            }
            else{
                prev = curr;
            }
            curr = curr.next;
        }

        return dummy.next;
    }
}