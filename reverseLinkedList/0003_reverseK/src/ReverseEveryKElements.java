import java.util.*;

class ListNode {
    int value = 0;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}

class ReverseEveryKElements {

    public static ListNode reverse(ListNode head, int k) {
        ListNode newHead = null;
        int count = 1;

        ListNode prev = null, cur = head, next = null;
        ListNode endOfPrev = null, end = null;

        while(cur!=null) {

            System.out.println("REVERSING..." + cur.value);
            //cache start of sublist  before reversal
            if(count%k==1) {
                endOfPrev = cur;
//                System.out.println(endOfPrev.value);
            }
            //reverse
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;

            //end of sublist?..
            if(count%k==0 || cur==null) {

//                System.out.println(count);

                //set head of first sublist as head of list
                if(newHead==null) newHead = prev;

                endOfPrev.next = cur;
                if(cur!=null) System.out.println(endOfPrev.value+"->"+endOfPrev.next.value);

            }
            count++;
        }



        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        ListNode result = ReverseEveryKElements.reverse(head, 3);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
