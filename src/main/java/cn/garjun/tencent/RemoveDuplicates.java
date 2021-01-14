package cn.garjun.tencent;

import java.util.Arrays;

/**
 * @author :liangjiajun
 * @date :20201017
 * @description 删除排序数组中的重复项
 * @email :jaron.liang@jodoinc.com
 */
public class RemoveDuplicates {
  public static int removeDuplicates(int[] nums) {
    if (nums.length <= 1) {
      return nums.length;
    }
    int index = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != nums[index - 1]) {
        nums[index] = nums[i];
        index++;
      }
    }
    System.out.println(index);
    return index;
  }

  public static void main(String[] args) {
    int[] nums = new int[] {1, 1};
    removeDuplicates(nums);
    System.out.println(Arrays.toString(nums));
  }
}
