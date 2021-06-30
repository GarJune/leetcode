package cn.garjun;

/**
 * @author :liangjiajun
 * @date :20210408
 * @description
 * @email :jaron.liang@jodoinc.com
 */
public class Solution {
  //   0 1 2 3 4 5 6
  // 0 P     I     N
  // 1 A   L S   I G
  // 2 Y A   H R
  // 3 P     I
  //                     14 length
  public static boolean isMonotonic(int[] nums) {

    if (nums.length == 1) {
      return true;
    }
    boolean add = true;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] < nums[i - 1]) {
        add = false;
      }
    }
    if (add) {
      return true;
    }
    boolean decrease = true;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > nums[i - 1]) {
        decrease = false;
      }
    }
    if (decrease) {
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 2};
    boolean result = isMonotonic(nums);
    System.out.println(result);
  }
}
