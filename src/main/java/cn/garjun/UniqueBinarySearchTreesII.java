package cn.garjun;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :liangjiajun
 * @date :20210607
 * @description
 * @email :jaron.liang@jodoinc.com
 */
public class UniqueBinarySearchTreesII {
  public List<TreeNode> generateTrees(int n) {
    if (n == 0) {
      return new ArrayList<>();
    }
    return buildTree(1, n);
  }

  private List<TreeNode> buildTree(int start, int end) {
    List<TreeNode> result = new ArrayList<>();
    if (start > end) {
      result.add(null);
      return result;
    }
    for (int i = start; i <= end; i++) {
      List<TreeNode> left = buildTree(start, i - 1);
      List<TreeNode> right = buildTree(i + 1, end);
      for (TreeNode leftNode : left) {
        for (TreeNode rightNode : right) {
          TreeNode treeNode = new TreeNode(i);
          treeNode.left = leftNode;
          treeNode.right = rightNode;
          result.add(treeNode);
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    UniqueBinarySearchTreesII test = new UniqueBinarySearchTreesII();
    List<TreeNode> list = test.generateTrees(3);
  }
}
