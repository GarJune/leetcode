package cn.garjun;

/**
 * @author :liangjiajun
 * @date :20210629
 * @description
 * @email :jaron.liang@jodoinc.com
 */
public class BuildTree {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder == null) {
      return null;
    }
    int top = preorder[0];
    TreeNode treeNode = new TreeNode(top);
    if (preorder.length == 1) {
      return treeNode;
    }
    for (int i = 0; i < inorder.length; i++) {
      if (inorder[i] == top) {
        if (i != 0) {
          int[] copy = new int[i];
          System.arraycopy(preorder, 1, copy, 0, i);
          int[] copyin = new int[i];
          System.arraycopy(inorder, 0, copyin, 0, i);
          treeNode.left = buildTree(copy, copyin);
        }
        if (i != inorder.length - 1) {
          int size = inorder.length - i - 1;
          int[] copy = new int[size];
          System.arraycopy(preorder, i + 1, copy, 0, size);
          int[] copyin = new int[size];
          System.arraycopy(inorder, i + 1, copyin, 0, size);
          treeNode.right = buildTree(copy, copyin);
        }
        break;
      }
    }
    return treeNode;
  }

  public static void main(String[] args) {
    int[] a = new int[] {3, 9, 20, 15, 7};
    int[] b = new int[] {9, 3, 15, 20, 7};
    BuildTree so = new BuildTree();
    TreeNode treeNode = so.buildTree(a, b);
    System.out.println(treeNode.right.left.val);
  }
}
