
//https://www.geeksforgeeks.org/move-last-element-to-front-of-a-given-linked-list/
import helpers.ListNode;

class app07 {
    void moveToFront(ListNode head) {
        if (head == null || head.next == null)
            return;
        ListNode secLast = null;
        ListNode last = head;
        while (last.next != null) {
            secLast = last;
            last = last.next;
        }
        head = last;
    }
}