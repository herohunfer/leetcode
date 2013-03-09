/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode sentinel = new ListNode(0);
        ListNode current = sentinel;
        int min1Index = 0;
        ListNode min1 = new ListNode(0);
        int min2V = Integer.MAX_VALUE;
        while (true) {
            min1Index = -1;
            for (int i = 0; i < lists.size(); i++) {
                if (lists.get(i) != null) {
                    min1Index = i;
                    min1 = lists.get(i);
                    break;
                }
            }
            if (min1Index < 0) break;
            min2V = Integer.MAX_VALUE;
            for (int i = 0; i < lists.size(); i++) {    
                if (lists.get(i) == null) continue;
                if (lists.get(i).val < min1.val) {
                    min2V = min1.val;
                    min1 = lists.get(i);
                    min1Index = i;
                }
                else if (lists.get(i).val < min2V) min2V = lists.get(i).val;
            }
            while (min1 != null && min1.val <= min2V) {
                current.next = new ListNode(min1.val);
                current = current.next;
                min1 = min1.next;
            }
            lists.set(min1Index, min1);
        }
        return sentinel.next;
        
    }
}
