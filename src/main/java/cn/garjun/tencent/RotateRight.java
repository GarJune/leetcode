package cn.garjun.tencent;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :liangjiajun
 * @date :20201118
 * @description 旋转链表
 * @email :jaron.liang@jodoinc.com
 */
public class RotateRight {
  //    输入: 1->2->3->4->5->NULL, k = 2
  //    输出: 4->5->1->2->3->NULL
  //    解释:
  //    向右旋转 1 步: 5->1->2->3->4->NULL
  //    向右旋转 2 步: 4->5->1->2->3->NULL
  public static ListNode rotateRight(ListNode head, int k) {
    if (head == null) {
      return null;
    }
    if (head.next == null) {
      return head;
    }
    k = k % checkLength(head);
    if (k == 0) {
      return head;
    }
    List<ListNode> list = new ArrayList<>();
    ListNode temp = head;
    while (temp != null) {
      list.add(temp);
      temp = temp.next;
    }
    list.get(list.size() - 1).next = list.get(0);
    list.get(list.size() - k - 1).next = null;
    return list.get(list.size() - k);
  }

  public static int checkLength(ListNode head) {
    int i = 0;
    while (head != null) {
      i++;
      head = head.next;
    }
    return i;
  }

  public static void main(String[] args) {
    int[] n1 = new int[] {1, 2};
    ListNode l1 = buildList(n1);
    ListNode head = rotateRight(l1, 0);
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
