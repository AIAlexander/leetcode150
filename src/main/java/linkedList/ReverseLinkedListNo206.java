package linkedList;

/**
 * @author wsh
 * @date 2024/1/24
 */
public class ReverseLinkedListNo206 {

    /**
     * 使用双指针实现链表倒转
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {

        if (head == null) {
            return head;
        }

        ListNode prev = head;
        ListNode cur = head.next;


        while (cur != null) {
            ListNode tmp = cur.next;
            if (prev == head) {
                prev.next = null;
            }
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }

    public static void main(String[] args) {

        ListNode h = new ListNode(1);

        ListNode h1 = new ListNode(2);
        ListNode h2 = new ListNode(3);
        ListNode h3 = new ListNode(4);
        ListNode h4 = new ListNode(5);

//        h.next = h1;
//        h1.next = h2;
//        h2.next = h3;
//        h3.next = h4;

        reverseList(h);

    }
}
