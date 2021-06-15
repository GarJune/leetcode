package cn.garjun;

/**
 * @author :liangjiajun
 * @date :20210122
 * @description
 * @email :jaron.liang@jodoinc.com
 */
public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  public TreeNode() {}

  public TreeNode(int val) {
    this.val = val;
  }

  public TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}
