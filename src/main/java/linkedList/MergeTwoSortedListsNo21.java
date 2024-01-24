package linkedList;

/**
 * @author wsh
 * @date 2024/1/22
 */
public class MergeTwoSortedListsNo21 {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dh = new ListNode();
        ListNode head = dh;


        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                head.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                head.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            head = head.next;
        }

        if (list1 != null) {
            head.next = list1;
        }

        if (list2 != null) {
            head.next = list2;
        }

        return dh.next;
    }

    public static void main(String[] args) {
        ListNode h = new ListNode(1);
        ListNode h1 = new ListNode(2);
        ListNode h2 = new ListNode(4);
        ListNode h3 = new ListNode(8);
        ListNode h4 = new ListNode(10);
        ListNode h5 = new ListNode(12);
        ListNode h6 = new ListNode(15);

        h.next = h1;
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;
        h5.next = h6;

        ListNode p = new ListNode(1);
        ListNode p1 = new ListNode(3);
        ListNode p2 = new ListNode(4);
//        ListNode p3 = new ListNode(9);

        p.next = p1;
        p1.next = p2;
//        p2.next = p3;

        ListNode listNode = mergeTwoLists(h, p);

        System.out.println(listNode);
    }
}
