package cn.garjun.tencent;

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

  TreeNode() {}

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}
