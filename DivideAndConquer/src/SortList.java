import data_structure.ListNode;

public class SortList {
    // 排序链表
    // 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 寻找链表中间节点
        ListNode mid = findMid(head);
        ListNode rightHead = mid.next;
        mid.next = null;
        // 分治算法
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);
        // 有序合并有序链表
        return merge(left, right);
    }

    private ListNode findMid(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = (l1 == null) ? l2 : l1;
        return dummy.next;
    }

}

