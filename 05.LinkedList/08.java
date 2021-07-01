import helpers.HelperFunctions;
import helpers.ListNode;

// https://practice.geeksforgeeks.org/problems/add-1-to-a-number-represented-as-linked-list/1#

class app08 {
    public static ListNode addOne(ListNode head) {
        head = HelperFunctions.reverseList(head);
        ListNode temp = head;
        ListNode prev = null;
        int sum = 0;
        int carry = 1;// for the one that is to be added
        while (temp != null) {
            sum = temp.val + carry;
            carry = sum / 10;
            temp.val = sum % 10;
            prev = temp;
            temp = temp.next;
        }
        if (carry > 0)
            prev.next = new ListNode(carry);
        head = HelperFunctions.reverseList(head);
        return head;
    }
}