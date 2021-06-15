package cn.garjun.tencent;

/**
 * @author :liangjiajun
 * @date :20210122
 * @description 二叉搜索树中第K小的元素
 * @email :jaron.liang@jodoinc.com
 */
public class KthSmallest {
  //    输入: root = [3,1,4,null,2], k = 1
  //            3
  //            / \
  //            1   4
  //            \
  //            2
  //    输出: 1
  public int kthSmallest(TreeNode root, int k) {
    int[] result = new int[k];
    middleIterate(root, result, 0, k);
    return result[result.length - 1];
  }

  public int middleIterate(TreeNode treeNode, int[] nums, int valid, int k) {
    if (valid == k) {
      return valid;
    }
    if (treeNode.left != null) {
      valid = middleIterate(treeNode.left, nums, valid, k);
    }
    if (valid == k) {
      return valid;
    }
    if (valid == 0 || nums[valid - 1] != treeNode.val) {
      nums[valid] = treeNode.val;
      valid++;
    }
    if (treeNode.right != null) {
      valid = middleIterate(treeNode.right, nums, valid, k);
    }
    return valid;
  }

  public static void main(String[] args) {
    TreeNode treeNode = new TreeNode(3);
    treeNode.left = new TreeNode(1);
    treeNode.right = new TreeNode(4);
    treeNode.left.right = new TreeNode(2);
    KthSmallest k = new KthSmallest();
    int result = k.kthSmallest(treeNode, 1);
    System.out.println(result);
  }
}
