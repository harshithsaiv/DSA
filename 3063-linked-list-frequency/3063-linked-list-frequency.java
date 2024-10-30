class Solution {
    public ListNode frequenciesOfElements(ListNode head) {
        Map<Integer, ListNode> frequencies = new HashMap<>();
        ListNode current = head;
        ListNode freqHead = null;

        while (current != null) {
            if (frequencies.containsKey(current.val)) {
                ListNode frequencyNode = frequencies.get(current.val);
                frequencyNode.val += 1;
            } else {
                ListNode newFrequencyNode = new ListNode(1, freqHead);
                frequencies.put(current.val, newFrequencyNode);
                freqHead = newFrequencyNode;
            }
            current = current.next;
        }
        return freqHead;
    }
}