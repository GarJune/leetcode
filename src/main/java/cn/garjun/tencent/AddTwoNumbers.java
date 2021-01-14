package cn.garjun.tencent;

/**
 * @author :liangjiajun
 * @date :20201113
 * @description 两数相加
 * @email :jaron.liang@jodoinc.com
 */
public class AddTwoNumbers {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    String numStr1 = findNum(l1);
    String numStr2 = findNum(l2);
    StringBuilder reverse = addTwoNumStr(numStr1, numStr2);
    ListNode head = new ListNode(reverse.charAt(0) - 48);
    ListNode temp = head;
    for (int i = 1; i < reverse.length(); i++) {
      temp.next = new ListNode(reverse.charAt(i) - 48);
      temp = temp.next;
    }
    return head;
  }

  public StringBuilder addTwoNumStr(String str1, String str2) {
    char[] c1 = new StringBuilder(str1).reverse().toString().toCharArray();
    char[] c2 = new StringBuilder(str2).reverse().toString().toCharArray();
    if (c1.length > c2.length) {
      return addTwoNumStr(str2, str1);
    }
    StringBuilder stringBuilder = new StringBuilder();
    int add = 0;
    for (int i = 0; i < c2.length; i++) {
      int first = 0;
      if (i < c1.length) {
        first = c1[i] - '0';
      }
      int second = c2[i] - '0';
      int result = first + second + add;
      stringBuilder.append(result % 10);
      add = result / 10;
    }
    if (add != 0) {
      stringBuilder.append(add);
    }
    return stringBuilder;
  }

  public String findNum(ListNode l) {
    if (l == null) {
      return "0";
    }
    if (l.next != null) {
      String str = findNum(l.next);
      return str + l.val;
    }
    return l.val + "";
  }

  public static void main(String[] args) {
    int[] n1 = new int[] {2, 4, 3};
    int[] n2 = new int[] {5, 6, 4};
    ListNode l1 = buildList(n1);
    ListNode l2 = buildList(n2);
    AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
    ListNode listNode = addTwoNumbers.addTwoNumbers(l1, l2);
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
