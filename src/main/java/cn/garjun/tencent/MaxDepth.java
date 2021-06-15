package cn.garjun.tencent;

/**
 * @author :liangjiajun
 * @date :20210125
 * @description 最大深度
 * @email :jaron.liang@jodoinc.com
 */
public class MaxDepth {
  private int max = 0;

  public int maxDepth(TreeNode root) {
    iterate(root, 0);
    return max;
  }

  private void iterate(TreeNode root, int current) {
    if (root == null) {
      return;
    }
    current = current + 1;
    if (max < current) {
      max = current;
    }
    iterate(root.left, current);
    iterate(root.right, current);
  }
}
