package linkedList;

/**
 * @author wsh
 * @date 2024/1/24
 */
public class ReverseLinkedListIINo96 {

    public static ListNode reverseBetween(ListNode head, int left, int right) {

        return reverseB(head, left, right);
    }


    public static ListNode[] reverse(ListNode head, ListNode s, int n) {
        if (n == 1) {
            // 反转结束
            // head的下一个节点，第一个节点需要指向s
            s = head.next;
            ListNode[] r = new ListNode[2];
            r[0] = head;
            r[1] = s;
            return r;
        }
        ListNode[] r = reverse(head.next, s, n - 1);
        // 递归结束，反转
        head.next.next = head;
        head.next = r[1];
        return r;
    }

    public static ListNode reverseB(ListNode head, int m, int n) {
        if (m == 1) {
           return reverse(head, null, n)[0];
        }
        head.next = reverseB(head.next, m - 1, n - 1);
        return head;
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

        ListNode listNode = reverseBetween(h, 2, 4);

    }
}
