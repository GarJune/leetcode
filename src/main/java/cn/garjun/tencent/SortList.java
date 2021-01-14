package cn.garjun.tencent;

/**
 * @author :liangjiajun
 * @date :20210103
 * @description 排序链表
 * @email :jaron.liang@jodoinc.com
 */
public class SortList {
  public ListNode sortList(ListNode head) {
    int length = 0;
    ListNode temp = head;
    while (temp != null) {
      length++;
      temp = temp.next;
    }
  }

  public ListNode partition(ListNode head, int start, int end) {
    if (head.next == null) {
      return head;
    }
    if (head.next.next == null) {
      if (head.val > head.next.val) {
        ListNode listNode = head;
        head = head.next;
        head.next = listNode;
      }
      return head;
    }
    int middle = (start + end) / 2;
    ListNode nextHead = head;
    int current = start;
    while (current < middle) {
      nextHead = nextHead.next;
      current++;
    }
    ListNode first = partition(head, start, middle);
    ListNode second = partition(nextHead, middle + 1, end);
  }
}
