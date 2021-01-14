package cn.garjun.tencent;

/**
 * @author :liangjiajun
 * @date :20201123
 * @description 相交链表
 * @email :jaron.liang@jodoinc.com
 */
public class GetIntersectionNode {
  //  输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
  //  输出：Reference of the node with value = 8
  //  输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A
  // 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
  public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) {
      return null;
    }
    ListNode temp = headA;
    int length1 = 0;
    while (temp != null) {
      temp = temp.next;
      length1++;
    }
    int length2 = 0;
    temp = headB;
    while (temp != null) {
      temp = temp.next;
      length2++;
    }
    if (length1 > length2) {
      return getIntersectionNode(headB, headA);
    }
    int distance = length2 - length1;
    for (int i = 0; i < distance; i++) {
      headB = headB.next;
    }
    while (headA != null && headB != null) {
      if (headA == headB) {
        return headA;
      }
      headA = headA.next;
      headB = headB.next;
    }
    return null;
  }

  public static void main(String[] args) {
    int[] nums = new int[] {4, 1};
    int[] nums2 = new int[] {5, 0, 1};
    int[] nums3 = new int[] {8, 4, 5};
    ListNode listNode3 = buildList(nums3);
    ListNode listNode = buildList(nums);
    ListNode listNode2 = buildList(nums2);
    ListNode temp = listNode;
    while (temp.next != null) {
      temp = temp.next;
    }
    temp.next = listNode3;
    temp = listNode2;
    while (temp.next != null) {
      temp = temp.next;
    }
    temp.next = listNode3;
    listNode = getIntersectionNode(listNode, listNode2);
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
