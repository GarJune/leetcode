package cn.garjun.tencent;

/**
 * @author :liangjiajun
 * @date :20201117
 * @description 合并K个排序链表
 * @email :jaron.liang@jodoinc.com
 */
public class MergeKLists {
  public static ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 0) {
      return null;
    }
    if (lists.length == 1) {
      return lists[0];
    }
    return mergeNode(lists, 0, lists.length - 1);
  }

  public static ListNode mergeNode(ListNode[] list, int l, int r) {
    if (l == r) {
      return list[l];
    }
    if (r - l <= 1) {
      return mergeTwoLists(list[l], list[r]);
    }
    int mid = (r + l) / 2;
    ListNode first = mergeNode(list, l, mid);
    ListNode second = mergeNode(list, mid + 1, r);
    return mergeTwoLists(first, second);
  }

  public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }
    ListNode head1 = l1;
    ListNode head2 = l2;
    ListNode last = null;
    while (l1 != null && l2 != null) {
      if (l1.val > l2.val) {
        if (last == null) {
          head1 = l2;
          l2 = l2.next;
          head1.next = l1;
          last = head1;
        } else {
          last.next = l2;
          l2 = l2.next;
          last.next.next = l1;
          last = last.next;
        }
      } else {
        last = l1;
        l1 = l1.next;
      }
    }
    while (l2 != null) {
      last.next = l2;
      l2 = l2.next;
      last = last.next;
    }
    return head1;
  }

  public static void main(String[] args) {
    int[] n1 = new int[] {1, 2, 3};
    int[] n2 = new int[] {4, 5, 6, 7};
    int[] n3 = new int[] {2, 6};
    ListNode l1 = buildList(n1);
    ListNode l2 = buildList(n2);
    ListNode l3 = buildList(n3);
    ListNode[] list = new ListNode[] {l1, l2, l3};
    //    ListNode[] list = new ListNode[] {null, null, null, null, null, null, null, null, null,
    // null};
    ListNode head = mergeKLists(list);
    while (head != null) {
      System.out.println(head.val);
      head = head.next;
    }
  }

  public static ListNode buildList(int[] nums) {
    ListNode listNode = new ListNode(nums[0]);
    ListNode head = listNode;
    for (int i = 1; i < nums.length; i++) {
      listNode.next = new ListNode(nums[i]);
      listNode = listNode.next;
    }
    return head;
  }
}
