package cn.garjun.tencent;

/**
 * @author :liangjiajun
 * @date :20210218
 * @description 最大子序列
 * @email :jaron.liang@jodoinc.com
 */
public class MaxSubArray {
  public int maxSubArray(int[] nums) {
    int max = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (nums[i - 1] > 0) {
        nums[i] = nums[i] + nums[i - 1];
      }
      if (nums[i] > max) {
        max = nums[i];
      }
    }
    return max;
  }

  public static void main(String[] args) {
    int[] ints = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    MaxSubArray maxSubArray = new MaxSubArray();
    int result = maxSubArray.maxSubArray(ints);
    System.out.println(result);
  }
}
