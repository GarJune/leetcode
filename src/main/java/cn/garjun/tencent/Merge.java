package cn.garjun.tencent;

/**
 * @author :liangjiajun
 * @date :20201112
 * @description 合并两个有序数组
 * @email :jaron.liang@jodoinc.com
 */
public class Merge {
  //    输入：
  //    nums1 = [1,2,3,0,0,0], m = 3
  //    nums2 = [2,5,6],       n = 3
  //
  //    输出：[1,2,2,3,5,6]
  public static void merge(int[] nums1, int m, int[] nums2, int n) {
    int size = m + n;
    int index = size - 1;
    int i = m - 1, j = n - 1;
    while (i >= 0 && j >= 0) {
      if (nums1[i] < nums2[j]) {
        nums1[index--] = nums2[j--];
      } else {
        nums1[index--] = nums1[i--];
      }
    }
    while (i >= 0) {
      nums1[index--] = nums1[i--];
    }
    while (j >= 0) {
      nums1[index--] = nums2[j--];
    }
  }

  public static void main(String[] args) {
    int[] nums1 = new int[] {1};
    int[] nums2 = new int[] {0};
    merge(nums1, 0, nums2, 1);
    for (int i = 0; i < nums1.length; i++) {
      System.out.println(nums1[i]);
    }
  }
}
