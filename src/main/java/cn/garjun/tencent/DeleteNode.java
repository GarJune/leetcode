package cn.garjun.tencent;

/**
 * @author :liangjiajun
 * @date :20201130
 * @description 删除节点
 * @email :jaron.liang@jodoinc.com
 */
public class DeleteNode {
  public static void deleteNode(ListNode node) {
    ListNode listNode = node;
    while (listNode.next != null) {
      listNode.val = listNode.next.val;
      if (listNode.next.next == null) {
        listNode.next = null;
      } else {
        listNode = listNode.next;
      }
    }
  }

  public static void main(String[] args) {
    int[] n1 = new int[] {4, 5, 1, 9};
    ListNode l1 = buildList(n1);
    deleteNode(l1.next);
    while (l1 != null) {
      System.out.println(l1.val);
      l1 = l1.next;
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
