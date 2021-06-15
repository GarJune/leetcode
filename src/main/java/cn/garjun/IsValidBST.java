package cn.garjun;

/**
 * @author :liangjiajun
 * @date :20210608
 * @description
 * @email :jaron.liang@jodoinc.com
 */
public class IsValidBST {

  public boolean isValidBST(TreeNode root) {
    return isValid(root, Long.MAX_VALUE, Long.MIN_VALUE);
  }

  public boolean isValid(TreeNode root, long max, long min) {
    if (root == null) {
      return true;
    }
    if (root.val >= max || root.val <= min) {
      return false;
    }
    return isValid(root.left, root.val, min) && isValid(root.right, max, root.val);
  }

  public static void main(String[] args) {
    TreeNode treeNode = new TreeNode();
    treeNode.val = 2;
    treeNode.left = new TreeNode(1);
    treeNode.right = new TreeNode(3);
    IsValidBST bst = new IsValidBST();
    boolean result = bst.isValidBST(treeNode);
    System.out.println(result);
  }
}
