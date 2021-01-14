package cn.garjun.tencent;

/**
 * @author :liangjiajun
 * @date :20201017
 * @description 盛最多水的容器
 * @email :jaron.liang@jodoinc.com
 */
public class MaxArea {
  public static int maxArea(int[] height) {
    //   0 1 2 3
    // 0 0 1 2 3
    // 1 1 0 1 2
    // 2 2 1 0 1
    // 3 3 2 1 0
    int max = Integer.MIN_VALUE;
    for (int i = 0, j = height.length - 1; i < j; ) {
      int min = Math.min(height[i], height[j]);
      int result = (j - i) * min;
      if (max < result) {
        max = result;
      }
      if (height[i] == min) {
        i++;
      } else {
        j--;
      }
    }
    return max;
  }

  public static void main(String[] args) {
    int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    maxArea(nums);
  }
}
