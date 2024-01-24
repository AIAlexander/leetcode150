package linkedList;

import java.util.List;

/**
 * @author wsh
 * @date 2024/1/24
 */
public class ReverseN {


    public static ListNode reverseN(ListNode head, int n) {
//        ListNode start = head;
//        return reverse(start, null, head, 0, n);

       return reverse(head, null, 3)[0];
    }

    public static ListNode reverse(ListNode start, ListNode prev, ListNode cur, int count, int n) {
        if (count == n ) {
            start.next = cur;
            return prev;
        }
        ListNode tmp = cur.next;
        cur.next = prev;
        count++;
        return reverse(start, cur, tmp, count, n);
    }

    public static ListNode[] reverse(ListNode head, ListNode s, int n) {
        if (n == 1) {
            s = head.next;
            ListNode[] r = new ListNode[2];
            r[0] = head;
            r[1] = s;
            return r;
        }

        ListNode[] r = reverse(head.next, s, n - 1);
        head.next.next = head;
        head.next = r[1];
        return r;
    }


    public static void main(String[] args) {
        ListNode h = new ListNode(1);

        ListNode h1 = new ListNode(2);
        ListNode h2 = new ListNode(3);
        ListNode h3 = new ListNode(4);
        ListNode h4 = new ListNode(5);

        h.next = h1;
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;

        ListNode node = reverseN(h, 3);

        System.out.println(1);
    }
}
