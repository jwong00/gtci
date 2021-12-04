class ListNode {
    int value = 0;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}

class LinkedListCycleStart {

    //assuming there IS a cycle
    public static ListNode findCycleStart(ListNode head) {
        int k = findCycleLength(head);
        ListNode ptr1 = head, ptr2 = head;

        for(int i=0;i<k;i++) ptr2 = ptr2.next;

        while(ptr1!=ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        return ptr1;
    }

    public static int findCycleLength(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
            if(slow==fast) return calculateLength(slow);
        }
        return 0;
    }

    public static int calculateLength(ListNode node) {
        ListNode t = node;
        int c = 0;
        do {
            t = t.next;
            c++;
        } while(t!=node);
        return c;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

        head.next.next.next.next.next.next = head;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);
    }
}
