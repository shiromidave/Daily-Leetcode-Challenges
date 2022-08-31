//  Palindrome Linked List
// TC-O(n)
// SC-O(1)
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

//Two pointer technique
//TC=O(n)
//SC=O(1)
//one is fast pointer and another is slow pointer
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode newList = null;
        ListNode left = head;
        ListNode right = head;
        
        while(left!=null && left.next!=null){
            left = left.next.next;
            right = right.next;
        }
        right = reversed(right);
        left = head;
        
        while(left!=null && right!=null){
            if(left.val!=right.val){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }
  private ListNode reversed(ListNode head){
        ListNode prev = null;
        
        while(head!=null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
