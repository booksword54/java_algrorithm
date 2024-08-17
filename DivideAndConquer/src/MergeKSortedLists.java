import data_structure.ListNode;

public class MergeKSortedLists {
    // 合并 K 个升序链表
    // 给你一个链表数组，每个链表都已经按升序排列。
    // 请你将所有链表合并到一个升序链表中，返回合并后的链表。
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) { // 只有一个元素，不用合并直接返回
            return lists[left];
        }
        if (left > right) { // 不构成链表
            return null;
        }
        int mid = ((right - left) >> 1) + left;
        // 分治：拆分成两个子任务，分别执行合并操作
        // 合并：合并排序后的子链表
        return mergeTwoList(merge(lists, left, mid), merge(lists, mid + 1, right));
    }

    private ListNode mergeTwoList(ListNode l1, ListNode l2) {
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
