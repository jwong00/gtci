
class ListNode {
    int value = 0;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}

class PalindromicLinkedList {

    public static boolean isPalindrome(ListNode head) {

        //find center
        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        //reverse right half
        ListNode right = reverse(slow), left = head;
        ListNode right_copy = right;

        while(left!=null && right!=null) {
            if(left.value!=right.value) {
                reverse(right_copy);
                return false;
            }
            left = left.next;
            right = right.next;
        }

        reverse(right_copy);
        return true;
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;

        while(head!=null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));

        head.next.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));
    }
}
