
class ListNode {
    int value = 0;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}

class RearrangeList {

    public static void reorder(ListNode head) {
        //find center
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode left = head, right = reverse(slow);
        ListNode head_reverse = right;

//        while(left!=null) {
//            System.out.println(left.value);
//            left = left.next;
//        }
//        System.out.println();
//        while(right!=null) {
//            System.out.println(right.value  );
//            right = right.next;
//        }

        //intersperse right half into left
        while(left !=null && right!=null) {
            ListNode next_left = left.next;
            left.next = right;
            left = next_left;


            ListNode next_right = right.next;
            right.next = left;
            right = next_right;
        }

        if(left != null) {
            left.next = null;
        }


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
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(12);
        RearrangeList.reorder(head);
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }
}
