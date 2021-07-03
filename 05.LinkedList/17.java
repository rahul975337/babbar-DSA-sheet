import helpers.HelperFunctions;
import helpers.ListNode;

//

class app17 {
    public boolean isPalindrome(ListNode head) {
        ListNode midNode = HelperFunctions.findMidNode(head);
        ListNode head2 = HelperFunctions.reverseList(midNode);
        ListNode head1 = head;
        while (head2 != null) {
            if (head1.val != head2.val)
                return false;
            head1 = head1.next;
            head2 = head2.next;
        }
        return true;
    }
}