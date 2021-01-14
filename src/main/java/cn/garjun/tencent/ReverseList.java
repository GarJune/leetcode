package cn.garjun.tencent;

/**
 * @author :liangjiajun
 * @date :20201112
 * @description 反转链表
 * @email :jaron.liang@jodoinc.com
 */
public class ReverseList {
  //    输入: 1->2->3->4->5->NULL
  //    输出: 5->4->3->2->1->NULL
  public static ListNode reverseList(ListNode head) {
    ListNode current = head;
    ListNode next = head.next;
    head.next = null;
    ListNode last = null;
    while (next != null) {
      last = current;
      current = next;
      next = current.next;
      current.next = last;
    }
    return current;
  }

  public static ListNode reverseList2(ListNode head) {
    return reverse(head, null);
  }

  public static ListNode reverse(ListNode now, ListNode last) {
    ListNode listNode = now;
    if (now.next != null) {
      listNode = reverse(now.next, now);
    }
    now.next = last;
    return listNode;
  }

  public static void main(String[] args) {
    int[] nums = new int[] {1, 2, 3, 4, 5};
    ListNode listNode = buildList(nums);
    listNode = reverseList2(listNode);
    while (listNode != null) {
      System.out.println(listNode.val);
      listNode = listNode.next;
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
