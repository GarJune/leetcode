package cn.garjun.tencent;

/**
 * @author :liangjiajun
 * @date :20201120
 * @description 环形链表
 * @email :jaron.liang@jodoinc.com
 */
public class HasCycle {
  public static boolean hasCycle(ListNode head) {
    if (head == null) {
      return false;
    }
    ListNode fast = head.next;
    ListNode slow = head;
    while (slow != null && fast != null && fast.next != null) {
      if (fast.next == slow) {
        return true;
      }
      slow = slow.next;
      fast = fast.next.next;
    }
    return true;
  }
}
