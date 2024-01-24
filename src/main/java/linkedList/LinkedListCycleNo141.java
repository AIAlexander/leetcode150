package linkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wsh
 * @date 2024/1/22
 */
public class LinkedListCycleNo141 {

    public static boolean hasCycle(ListNode head) {

        ListNode cur = head;

        Set<ListNode> set = new HashSet<>();

        while (cur != null) {
            if (set.contains(cur)) {
                return true;
            }
            set.add(cur);
            cur = cur.next;
        }
        return false;
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
//        h4.next = h2;

        System.out.println(hasCycle(h));

    }
}
