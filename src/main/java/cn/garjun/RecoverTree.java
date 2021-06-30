package cn.garjun;

import java.util.*;

/**
 * @author :liangjiajun
 * @date :20210615
 * @description 恢复二叉搜索树
 * @email :jaron.liang@jodoinc.com
 */
public class RecoverTree {
  private List<Integer> list = new ArrayList<>();
  Map<Integer, Integer> map = new HashMap<>();

  public void recoverTree(TreeNode root) {
    middleTraverse(root);
    List<Integer> sortList = new ArrayList<>(list);
    Collections.sort(sortList);
    for (int i = 0; i < sortList.size(); i++) {
      Integer first = sortList.get(i);
      Integer second = list.get(i);
      if (!first.equals(second)) {
        map.put(second, first);
      }
    }
    replace(root);
    return;
  }

  public void replace(TreeNode root) {
    if (map.containsKey(root.val)) {
      root.val = map.get(root.val);
    }
    if (root.left != null) {
      replace(root.left);
    }
    if (root.right != null) {
      replace(root.right);
    }
  }

  public void middleTraverse(TreeNode root) {
    if (root.left != null) {
      middleTraverse(root.left);
    }
    list.add(root.val);
    if (root.right != null) {
      middleTraverse(root.right);
    }
  }
}
