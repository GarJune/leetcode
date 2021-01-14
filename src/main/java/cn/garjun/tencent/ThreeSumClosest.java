package cn.garjun.tencent;

import java.util.Arrays;

/**
 * @author :liangjiajun
 * @date :20201015
 * @description 最接近的三数之和
 * @email :jaron.liang@jodoinc.com
 */
public class ThreeSumClosest {

  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int distance = Integer.MAX_VALUE;
    int closest = 0;
    for (int i = 0; i < nums.length - 2; i++) {
      int first = target - nums[i];
      for (int j = i + 1, k = nums.length - 1; k > j; ) {
        int result = nums[j] + nums[k] - first;
        if (Math.abs(result) < distance) {
          distance = Math.abs(result);
          closest = nums[j] + nums[k] + nums[i];
        }
        if (result > 0) {
          k--;
        } else if (result < 0) {
          j++;
        } else {
          return closest;
        }
      }
    }
    return closest;
  }

  public static void main(String[] args) {
    ThreeSumClosest closest = new ThreeSumClosest();
    int[] nums = new int[] {1, 2, 4, 8, 16, 32, 64, 128};
    int result = closest.threeSumClosest(nums, 82);
    System.out.println(result);
  }
}
