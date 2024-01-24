package linkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wsh
 * @date 2024/1/22
 */
public class LinkedListCycle2No141 {

    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (true) {
            for (int i = 0; i < 2; i++) {
                if (fast.next == null) {
                    return false;
                }
                fast = fast.next;
            }

            if (slow.next == null) {
                return false;
            }
            slow = slow.next;

            if (slow == fast) {
                return true;
            }
        }
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
        h4.next = h2;

        System.out.println(hasCycle(h));

    }
}
