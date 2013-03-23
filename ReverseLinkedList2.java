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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode sentinel = new ListNode(Integer.MIN_VALUE+1);
        sentinel.next = head;
        ListNode start = sentinel, previous = sentinel, next = sentinel, ReverseHead = sentinel;
        ListNode current = head;
        int num = 1;
        while (current != null) {
            if (num == m) {
                ReverseHead = current;
                previous = current;
                current = current.next;
            }
            else if (num > m && num < n) {
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }
            else if (num == n) {
                next = current.next;
                current.next = previous;
                
                // fix 2 -> 5
                ReverseHead.next = next;
                start.next = current;
                current = next;
            }
            else {
                start = start.next;
                previous = current;
                current = current.next;
            }
            num++;
        }
        return sentinel.next;
    }
}
