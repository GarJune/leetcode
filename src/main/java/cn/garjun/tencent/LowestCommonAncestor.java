package cn.garjun.tencent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author :liangjiajun
 * @date :20210126
 * @description 最近公共祖先
 * @email :jaron.liang@jodoinc.com
 */
public class LowestCommonAncestor {
  private Map<Integer, TreeNode> map = new TreeMap<>();
  private Map<Integer, TreeNode> valueMap = new TreeMap<>();

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    calculateSize(root);
    TreeNode parent1 = map.get(p.val);
    TreeNode parent2 = map.get(q.val);
    List<Integer> list = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();
    list2.add(q.val);
    list.add(p.val);
    while (parent1 != null) {
      list.add(parent1.val);
      parent1 = map.get(parent1.val);
    }
    while (parent2 != null) {
      list2.add(parent2.val);
      parent2 = map.get(parent2.val);
    }
    System.out.println(list);
    System.out.println(list2);
    for (int i = 0; i < list.size(); i++) {
      if (list2.contains(list.get(i))) {
        System.out.println("o:" + list.get(i));
        return valueMap.get(list.get(i));
      }
    }
    return null;
  }

  private void calculateSize(TreeNode root) {
    if (root == null) {
      return;
    }
    valueMap.put(root.val, root);
    if (root.left != null) {
      map.put(root.left.val, root);
    }
    if (root.right != null) {
      map.put(root.right.val, root);
    }
    calculateSize(root.left);
    calculateSize(root.right);
  }

  //  [5,3,6,2,4,null,null,1]
  //          1
  //          4
  public static void main(String[] args) {
    TreeNode treeNode = new TreeNode(3);
    treeNode.left = new TreeNode(5);
    treeNode.right = new TreeNode(1);
    treeNode.left.left = new TreeNode(6);
    treeNode.left.right = new TreeNode(2);
    treeNode.right.left = new TreeNode(0);
    treeNode.right.right = new TreeNode(8);
    treeNode.left.right.left = new TreeNode(7);
    treeNode.left.right.right = new TreeNode(4);
    LowestCommonAncestor l = new LowestCommonAncestor();
    TreeNode root = l.lowestCommonAncestor(treeNode, treeNode.left, treeNode.left.right.right);
    System.out.println(root.val);
  }
}
