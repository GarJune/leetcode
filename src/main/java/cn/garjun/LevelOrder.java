package cn.garjun;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author :liangjiajun
 * @date :20210524
 * @description
 * @email :jaron.liang@jodoinc.com
 */
public class LevelOrder {
  public List<List<Integer>> levelOrder(TreeNode root) {
    Deque<TreeNode> deque = new LinkedList<TreeNode>();
    deque.push(root);
    List<List<Integer>> list = new ArrayList<>();
    while (!deque.isEmpty()) {
      List<Integer> strings = new ArrayList<>();
      int nowSize = deque.size();
      for (int i = 0; i < nowSize; i++) {
        TreeNode node = deque.pop();
        if (node.right != null) {
          deque.push(node.right);
        }
        if (node.left != null) {
          deque.push(node.left);
        }
        strings.add(node.val);
      }
      list.add(strings);
    }
    return list;
    //
  }
}
