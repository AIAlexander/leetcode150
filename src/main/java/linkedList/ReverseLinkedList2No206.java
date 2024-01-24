package linkedList;

/**
 * @author wsh
 * @date 2024/1/24
 */
public class ReverseLinkedList2No206 {

    /**
     * 递归方式实现链表倒转
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {

        return reverse(head);
    }

    public static ListNode reverse(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;

    }

    public static ListNode reverse(ListNode prev, ListNode cur) {
        if (cur == null) {
            return prev;
        }
        ListNode tmp = cur.next;
        cur.next = prev;
        return reverse(cur, tmp);
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

        reverseList(h);
    }
}
