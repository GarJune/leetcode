package cn.garjun.tencent;

/**
 * @author :liangjiajun
 * @date :20201112
 * @description 链表结构
 * @email :jaron.liang@jodoinc.com
 */
public class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}
