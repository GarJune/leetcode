package cn.garjun.tencent;

/**
 * @author :liangjiajun
 * @date :20210103
 * @description 排序链表
 * @email :jaron.liang@jodoinc.com
 */
public class SortList {
  public static ListNode sortList(ListNode head) {
    if (head == null) {
      return null;
    }
    int length = 0;
    ListNode temp = head;
    while (temp != null) {
      length++;
      temp = temp.next;
    }
    return partition(head, 0, length - 1);
  }

  public static ListNode partition(ListNode head, int start, int end) {
    if (head.next == null) {
      return head;
    }
    if (head.next.next == null) {
      if (head.val > head.next.val) {
        ListNode listNode = head;
        head = head.next;
        head.next = listNode;
        head.next.next = null;
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
    ListNode secondHead = nextHead.next;
    nextHead.next = null;
    ListNode first = partition(head, start, middle);
    ListNode second = partition(secondHead, middle + 1, end);
    return merge(first, second);
  }

  public static ListNode merge(ListNode first, ListNode second) {
    ListNode head;
    if (first.val < second.val) {
      head = first;
      first = first.next;
    } else {
      head = second;
      second = second.next;
    }
    ListNode result = head;
    while (first != null && second != null) {
      if (first.val < second.val) {
        head.next = first;
        first = first.next;
        head = head.next;
      } else {
        head.next = second;
        second = second.next;
        head = head.next;
      }
    }
    while (first != null) {
      head.next = first;
      first = first.next;
      head = head.next;
    }
    while (second != null) {
      head.next = second;
      second = second.next;
      head = head.next;
    }
    return result;
  }

  public static void main(String[] args) {
    int[] nums = new int[] {};
    ListNode listNode = buildList(nums);
    listNode = sortList(listNode);
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
