package cn.garjun.tencent;

/**
 * @author :liangjiajun
 * @date :20210125
 * @description 最大路径和
 * @email :jaron.liang@jodoinc.com
 */
public class MaxPathSum {
  //    输入：root = [1,2,3]
  //    输出：6
  //    解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6

  //    输入：root = [-10,9,20,null,null,15,7]
  //    输出：42
  //    解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
  //
  private Integer MAX = null;

  public int maxPathSum(TreeNode root) {
    iterate(root);
    return MAX;
  }

  public int iterate(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int max = root.val;
    int left = iterate(root.left);
    if (left + root.val > max) {
      max = left + root.val;
    }
    int right = iterate(root.right);
    if (right + root.val > max) {
      max = right + root.val;
    }
    if (MAX == null || (left + right + root.val) > MAX) {
      MAX = left + right + root.val;
    }
    if (max > MAX) {
      MAX = max;
    }
    return max;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode();
    root.val = -10;
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);
    MaxPathSum maxPathSum = new MaxPathSum();
    int result = maxPathSum.maxPathSum(root);
    System.out.println(result);
  }
}
