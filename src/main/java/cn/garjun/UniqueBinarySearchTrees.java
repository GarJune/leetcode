package cn.garjun;

/**
 * @author :liangjiajun
 * @date :20210607
 * @description
 * @email :jaron.liang@jodoinc.com
 */
public class UniqueBinarySearchTrees {
  public int generateTrees(int n) {
    if (n == 0) {
      return 0;
    }
    return buildTree(1, n);
  }

  private int buildTree(int start, int end) {
    if (end - start == 1) {
      return 2;
    }
    if (end - start == 0) {
      return 1;
    }
    if (end < start) {
      return 0;
    }
    int totalResult = 0;
    for (int i = start; i <= end; i++) {
      int result = 0;
      int left = buildTree(start, i - 1);
      int right = buildTree(i + 1, end);
      result = left * right;
      if (left == 0) {
        result = right;
      }
      if (right == 0) {
        result = left;
      }
      totalResult += result;
    }
    return totalResult;
  }

  public static void main(String[] args) {
    UniqueBinarySearchTrees test = new UniqueBinarySearchTrees();
    int result = test.generateTrees(3);
    System.out.println(result);
  }
}
