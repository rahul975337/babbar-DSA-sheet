
//https://practice.geeksforgeeks.org/problems/circular-linked-list/1
import helpers.ListNode;

class app15 {
    boolean isCircular(ListNode head) {
        if (head == null)
            return false;
        ListNode temp = head.next;
        while (temp != null) {
            temp = temp.next;
            if (temp == head)
                return true;
        }
        return false;
    }
}