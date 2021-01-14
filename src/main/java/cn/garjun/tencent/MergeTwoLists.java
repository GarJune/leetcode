package cn.garjun.tencent;

/**
 * @author :liangjiajun
 * @date :20201115
 * @description 合并两个有序链表
 * @email :jaron.liang@jodoinc.com
 */
public class MergeTwoLists {
  //    输入：1->2->4, 1->3->4
  //    输出：1->1->2->3->4->4
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

  //  public static void main(String[] args) {
  //    int[] n1 = new int[] {2};
  //    int[] n2 = new int[] {1};
  //    ListNode l1 = buildList(n1);
  //    ListNode l2 = buildList(n2);
  //    ListNode head = mergeTwoLists(l1, l2);
  //    while (head != null) {
  //      System.out.println(head.val);
  //      head = head.next;
  //    }
  //  }

  public static void main(String[] args) {
    int hash = Math.abs("112.73.0.56".hashCode());
    long ran = hash % 100;
    System.out.println(ran);
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
