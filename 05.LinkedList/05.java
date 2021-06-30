
//https://leetcode.com/problems/remove-duplicates-from-sorted-list/submissions/
import helpers.ListNode;

//Naive approach can be to take a hashset and then making the list again
//Efficient approach
class app05 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode temp = head;
        while (temp.next != null) {
            if (temp.val == temp.next.val)
                temp.next = temp.next.next;
            else
                temp = temp.next;
        }
        return head;
    }
}