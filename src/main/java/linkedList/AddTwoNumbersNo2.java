package linkedList;

/**
 * @author wsh
 * @date 2024/1/22
 */
public class AddTwoNumbersNo2 {


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode res = new ListNode();
        ListNode head = res;
        int addNum = 0;

        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + addNum;
            if (val >= 10) {
                addNum = 1;
                val = val - 10;
            } else {
                addNum = 0;
            }
            ListNode tmp = new ListNode(val);
            head.next = tmp;
            head = tmp;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int val = l1.val + addNum;
            if (val >= 10) {
                addNum = 1;
                val = val - 10;
            } else {
                addNum = 0;
            }
            ListNode tmp = new ListNode(val);
            head.next = tmp;
            head = tmp;
            l1 = l1.next;
        }

        while (l2 != null) {
            int val = l2.val + addNum;
            if (val >= 10) {
                addNum = 1;
                val = val - 10;
            } else {
                addNum = 0;
            }
            ListNode tmp = new ListNode(val);
            head.next = tmp;
            head = tmp;
            l2 = l2.next;
        }

        if (addNum != 0) {
            ListNode tmp = new ListNode(1);
            head.next = tmp;
            head = tmp;
        }

        return res.next;
    }

    public static void main(String[] args) {

        ListNode h = new ListNode(9);
        ListNode h1 = new ListNode(9);
        ListNode h2 = new ListNode(9);
        ListNode h3 = new ListNode(9);
        ListNode h4 = new ListNode(9);
        ListNode h5 = new ListNode(9);
        ListNode h6 = new ListNode(9);

        h.next = h1;
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;
        h5.next = h6;

        ListNode p = new ListNode(9);
        ListNode p1 = new ListNode(9);
        ListNode p2 = new ListNode(9);
        ListNode p3 = new ListNode(9);

        p.next = p1;
        p1.next = p2;
        p2.next = p3;

        ListNode listNode = addTwoNumbers(h, p);


        System.out.println(listNode);

    }
}
